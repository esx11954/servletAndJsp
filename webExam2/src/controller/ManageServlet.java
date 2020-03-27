package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btn = request.getParameter("btn");
		String next = null;
		
		if(btn != null) {
			switch (btn) {
			case "insert":
				next = "InsertServlet";
				break;
			case "search":
				next = "SearchServlet";
				break;
			case "edit":
				next = "EditServlet";
				break;
			case "delete":
				next = "DeleteServlet";
				break;
			default:
				next = "manage.jsp";
				break;
			}
		}else {
			next = "manage.jsp";
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/" + next);
		dis.forward(request, response);
	}
}
