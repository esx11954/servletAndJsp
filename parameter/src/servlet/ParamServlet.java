package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * パラメータ学習用サーブレット
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	boolean flag = false;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 想定する遷移前のロケーション(URL)
		String url = "http://localhost:8080/parameter/param.html";
		
		// ヘッダーのリファラ(遷移前のURL)を取得
		String referer = request.getHeader("Referer");
		
		// 想定外のロケーションからアクセスされた場合
		if(referer == null || !referer.equals(url)) {
			// リダイレクト
			response.sendRedirect(url);
			
		// 期待するロケーションからアクセスされた場合
		}else {
			
			// inputタグのname属性の値を指定してパラメータを取得 
			String text = request.getParameter("text");
			
			// テキストボックスに何か入力されていた場合
			if(!text.isEmpty()) {
				request.setAttribute("text", text);
				
			// テキストボックスに何も入力されていなかった場合
			}else {
				request.setAttribute("text", "空文字です");
			}
			
			request.setAttribute("flag", flag);
			request.setAttribute("cssFile", "get");
			
			dispatch(request, response, "/param.jsp");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// パラメータを受取る変数
		int text = 0;
		flag = true;
		
		try {
			// inputタグのname属性の値を指定してパラメータを取得 
			text = Integer.parseInt(request.getParameter("text"));
			
			// 受け取った値が1未満なら例外発生(catch句に飛ぶ)
			if(text < 1) throw new NumberFormatException();
			
			// 1以上の場合
			request.setAttribute("text", text + "回繰り返します");
			
		}catch(NumberFormatException e) {
			dispatch(request, response, "/param.html");
			return;
		}
		
		// Randomクラス(API)をインスタンス化
		Random random = new Random();
		
		// 16進数(カラーコード)の値を持つ配列
		String[] colorArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

		
		ArrayList<String> list = new ArrayList<>();
		
		// パラメータに受け取った数値の回数分繰り返し
		for(int i = 1; i <= text; i++) {
			String colorCode = "#";
			
			// 6回(カラーコードは6桁)繰り返し...カラーコードの生成
			for(int j = 0; j < 6; j++) {
				colorCode += colorArray[random.nextInt(16)];	
			}
			list.add(colorCode);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("flag", flag);
		request.setAttribute("cssFile", "post");
		
		dispatch(request, response, "/param.jsp");
	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String fileName) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher(fileName);
		dis.forward(request, response);
	}

}
