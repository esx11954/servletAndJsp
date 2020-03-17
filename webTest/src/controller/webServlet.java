package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servise.DBAccess;
import servise.Delete;
import servise.Insert;
import servise.Select;

/**
 * Servlet implementation class webServlet
 */
@WebServlet("/webServlet")
public class webServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DBAccess dbAccess;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("servlet test haha?...1");
		
		dbAccess = new Select();
		try {
			dbAccess.excute(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/jspTest.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");...filterを用意したので必要なし
		String btn = request.getParameter("button");
		System.out.println(btn);
		try {
			
			// DB挿入処理 
			if(btn.equals("submit")) {
				String input = request.getParameter("text");
				// 100文字以上ならdoGet
				if(input.length() >= 100 || input.equals("") || input == null) {
					request.setAttribute("message", "何も入力されていないか、100文字を超えています");
					doGet(request, response);
					return;
				}
				dbAccess = new Insert();
				dbAccess.excute(request);
			
			// DB削除処理
			}else {
				dbAccess = new Delete();
				dbAccess.excute(request);
			}

			// 全データ抽出処理
			dbAccess = new Select();
			dbAccess.excute(request);
		}catch(Exception e) {
			System.out.println("Exception occured...");
			System.out.println(e);
		}

		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/jspTest.jsp");
		dis.forward(request, response);
	}
}
