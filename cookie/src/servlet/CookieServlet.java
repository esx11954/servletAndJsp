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
		
		// ここに処理を記入してください
		
		String valueId = "";
		String valuePass = "";
		String message ="IDを入力するとクッキーが発行されます";
		
		// ここに処理を記入してください
		
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

		// ここに処理を記入してください
		
		String message = "入力が不正です<br>やり直してください";
		
		// ここに処理を記入してください
		
		request.setAttribute("message", message);
		
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/confirm.jsp");
		dis.forward(request, response);
	}
}
