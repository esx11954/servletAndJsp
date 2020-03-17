package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Cookie[] cookies = request.getCookies();
		String value ="ここにIDを入力してね";
		String message ="IDを入力するとクッキーが発行されます";
		if(cookies != null) {
			for(Cookie c: cookies) {
				if(c.getName().equals("id")) {
					String cookie = URLDecoder.decode(c.getValue(), "UTF-8");
					value = cookie;
					message = "おかえりなさい<br>IDはこちらで入力しておきました";
				}
			}
		}
		
		request.setAttribute("idValue", value);
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
		String id = request.getParameter("id");
		
		if(id != null && !id.isEmpty()) {
			String eId = URLEncoder.encode(id, "UTF-8");
			Cookie cookie = new Cookie("id", eId);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			request.setAttribute("message", "クッキーを発行しました<br>TOPに戻ってみてね");
		}else {
			request.setAttribute("message", "やり直してください");
		}
		
		
		/*
		 * パスワードもクッキーとして保存してみる？
		 * その場合クッキー発行をmodel化してもいいかもしれない
		 */
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/confirm.jsp");
		dis.forward(request, response);
	}
}
