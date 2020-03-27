package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EL式学習用サーブレット
 */
@WebServlet("/ElJstlServlet")
public class ElJstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 文字列"el expression"と"post"を画面に渡す
		request.setAttribute("head", "el expression");
		request.setAttribute("method", "post");
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/el.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 文字列"EL EXPRESSION"と"get"を画面に渡す
		request.setAttribute("head", "EL EXPRESSION");
		request.setAttribute("method", "get");
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/el.jsp");
		dis.forward(request, response);
	}

}
