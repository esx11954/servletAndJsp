package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletとJSP学習用サーブレット
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 現在時刻、文字列"doGet"を画面に渡す
		request.setAttribute("date", new Date());
		request.setAttribute("doWhich", "doGet");
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/view.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 現在時刻、文字列"doPost"を画面に渡す
		request.setAttribute("date", new Date());
		request.setAttribute("doWhich", "doPost");
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/view.jsp");
		dis.forward(request, response);
	}

}
