package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.FoodBean;
import logic.CreateMenu;

/**
 * Servlet implementation class BeansServlet
 */
@WebServlet("/BeansServlet")
public class BeansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("menuList", CreateMenu.createMenuList());
		
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/beansTop.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(false);
		int index;
		
		String btn = request.getParameter("btn");
		
		try {
			// 変更ボタンが押された場合
			if(btn.equals("変更")) {
				index = Integer.parseInt(request.getParameter("index"));
				session.setAttribute("index", index);
				ArrayList<FoodBean> bean = (ArrayList<FoodBean>) session.getAttribute("menuList");
				request.setAttribute("editItem", bean.get(index));
				
				ServletContext context = getServletContext();
				RequestDispatcher dis = context.getRequestDispatcher("/edit.jsp");
				dis.forward(request, response);
				
			// 確定ボタンが押された場合
			}else if(btn.equals("確定")) {
				index = (int) session.getAttribute("index");
				CreateMenu.names[index] = request.getParameter("foodName");
				CreateMenu.prices[index] = Integer.parseInt(request.getParameter("price"));
				CreateMenu.kcals[index] = Integer.parseInt(request.getParameter("kcal"));
				CreateMenu.descriptions[index] = request.getParameter("description");
				doGet(request, response);
			}
		}catch(Exception e) {
			request.setAttribute("message", "エラーが発生しました");
			doGet(request, response);
		}
	}
}
