package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookieService.CookieFac;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// クライアントからクッキーを配列で取得
		Cookie[] cookies = request.getCookies();
		String valueId = "";
		String valuePass = "";
		String message ="IDを入力するとクッキーが発行されます";
		
		if(cookies != null) {
			for(Cookie c: cookies) {
				
				// クッキー名が
				switch(c.getName()) {
				
				// "id"だった場合
				case ("id"):
					// クッキーをデコード(読み取れる形式に変換)
					valueId = URLDecoder.decode(c.getValue(), "UTF-8");
					request.setAttribute("valueId", valueId);
					message = "おかえりなさい<br>" + valueId + "さん";
					break;
				
				// "pass"だった場合
				case ("pass"):
					// クッキーをデコード(読み取れる形式に変換)
					valuePass = URLDecoder.decode(c.getValue(), "UTF-8");
					request.setAttribute("valuePass", valuePass);
					break;
				}
			}
		}
		request.setAttribute("title", message);
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/cookie.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// パラメータの受け取り
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// クッキー生成処理
		Cookie idCookie = CookieFac.getCookie(id , "id");
		Cookie passCookie = CookieFac.getCookie(pass, "pass");
		
		String message = "入力が不正です<br>やり直してください";
		
		if(idCookie != null && passCookie != null) {
			// クライアントへのクッキー発行処理
			response.addCookie(idCookie);
			response.addCookie(passCookie);
			message = "クッキーを発行しました<br>TOPに戻ってみてね";
		}
		
		request.setAttribute("message", message);
		
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/confirm.jsp");
		dis.forward(request, response);
	}
}
