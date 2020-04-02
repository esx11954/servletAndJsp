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

import dbAccess.DBAccess;
import dbAccess.SelectAll;
import dbAccess.SelectCategory;
import dbAccess.SelectName;
import dbAccess.SelectPrice;

/**
 * 商品検索時のサーブレット<br>
 * ・doGet...doPostへ<br>
 * ・doPost...DBへの検索処理の呼び出し
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DBAccess dbAccess;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String selectWay = request.getParameter("selectWay");
		
		switch (selectWay){
		case "name":
			dbAccess = new SelectName();
			break;
		case "category":
			dbAccess = new SelectCategory();
			break;
		case "price":
			dbAccess = new SelectPrice();
			break;
		case "all":
			dbAccess = new SelectAll();
			break;
		}
		try {
			dbAccess.execute(request);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/manage.jsp");
		dis.forward(request, response);
	}
}
