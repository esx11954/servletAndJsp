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
 * DB学習用サーブレット
 */
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DBAccess dbAccess;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 全データ抽出処理
		
		// ここに処理を記入してください
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/db.jsp");
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
			
			// ここに処理を記入してください
			
			// 全データ抽出処理
			doGet(request, response);
		}catch(Exception e) {
			System.out.println("Exception occured...");
			System.out.println(e);
		}
	}
}
