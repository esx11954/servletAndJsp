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
 * Servlet implementation class ParamServlet
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

		// リダイレクト処理でhtmlに飛ばす
		String url = "http://localhost:8080/parameter/param.html";
		String referer = request.getHeader("Referer");
		if(referer == null || !referer.equals(url)) {
			response.sendRedirect(url);
		}else {
			String text = request.getParameter("text");
			
			if(!text.isEmpty()) {
				request.setAttribute("text", text);
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
		
		int text = 0;
		flag = true;
		
		try {
			text = Integer.parseInt(request.getParameter("text"));
			if(text < 1) throw new NumberFormatException(); 
			request.setAttribute("text", text + "回繰り返します");
		}catch(NumberFormatException e) {
			dispatch(request, response, "/param.html");
			return;
		}
		
		Random random = new Random();
		String[] colorArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

		
		ArrayList<String> list = new ArrayList<>();
		for(int i = 1; i <= text; i++) {
			String colorCode = "#";
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
