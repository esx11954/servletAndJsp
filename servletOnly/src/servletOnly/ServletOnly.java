package servletOnly;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletOnly
 */
@WebServlet("/ServletOnly")
public class ServletOnly extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>jspページ</title>");
		out.println("<link rel=\"stylesheet\" href=\"style.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>DoGetを動かしました</h1>");
		out.println("<p>" + new Date() + "</p>");
		out.println("<form action=\"ServletOnly\" method=\"get\">");
		out.println("<input type=\"submit\" value=\"get\">");
		out.println("</form>");
		out.println("<form action=\"ServletOnly\" method=\"post\">");
		out.println("<input type=\"submit\" value=\"post\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>jspページ</title>");
		out.println("<link rel=\"stylesheet\" href=\"style.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>DoPostを動かしました</h1>");
		out.println("<p>" + new Date() + "</p>");
		out.println("<form action=\"ServletOnly\" method=\"get\">");
		out.println("<input type=\"submit\" value=\"get\">");
		out.println("</form>");
		out.println("<form action=\"ServletOnly\" method=\"post\">");
		out.println("<input type=\"submit\" value=\"post\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
