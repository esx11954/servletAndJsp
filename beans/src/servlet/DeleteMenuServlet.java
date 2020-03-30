package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.FoodBean;

/**
 * Bean削除、初期化用サーブレット
 */
@WebServlet("/DeleteMenuServlet")
public class DeleteMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// edit.jspで削除ボタンを押したときの処理
		HttpSession session = request.getSession(false);
		ArrayList<FoodBean> menuList = (ArrayList<FoodBean>) session.getAttribute("menuList");
		
		int index = Integer.parseInt(request.getParameter("index"));
		String delName = menuList.get(index).getFoodName();
		session.setAttribute("message", delName + " を削除しました");
		menuList.remove(index);
		session.setAttribute("menuList", menuList);
		
		response.sendRedirect("http://localhost:8080/beans/BeansServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// メニュー初期化処理
		HttpSession session = request.getSession(false);
		if(session != null) session.invalidate();
		response.sendRedirect("http://localhost:8080/beans/BeansServlet");
	}
}
