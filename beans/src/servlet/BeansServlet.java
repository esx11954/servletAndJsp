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
import initialize.CreateMenu;

/**
 * Bean学習用サーブレット
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

		// セッションにメニューが登録されていなければ新規作成(初期メニュー)
		if(session.getAttribute("menuList") == null) {
			session.setAttribute("menuList", CreateMenu.createMenuList());
		}
		
		// メニュー追加時に例外が発生したらメッセージのスコープを移し替える
		if(session.getAttribute("message") != null) {
			String message = (String) session.getAttribute("message");
			request.setAttribute("message", message);
			session.removeAttribute("message");
		}

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
		
		int index;
		String btn = request.getParameter("btn");
		
		HttpSession session = request.getSession(false);
		ArrayList<FoodBean> menuList = (ArrayList<FoodBean>) session.getAttribute("menuList");
		
		try {
			// 変更ボタンが押された場合
			if(btn.equals("変更")) {
				index = Integer.parseInt(request.getParameter("index"));
				session.setAttribute("index", index);
				
				request.setAttribute("editItem", menuList.get(index));
				request.setAttribute("servlet", "BeansServlet");
				request.setAttribute("editOrAdd", "編集");
				
				ServletContext context = getServletContext();
				RequestDispatcher dis = context.getRequestDispatcher("/edit.jsp");
				dis.forward(request, response);
				
			// 確定ボタンが押された場合
			}else if(btn.equals("確定")) {
				index = (int) session.getAttribute("index");
				FoodBean bean = menuList.get(index);
				bean.setFoodName(request.getParameter("foodName"));
				bean.setPrice(Integer.parseInt(request.getParameter("price")));
				bean.setKcal(Integer.parseInt(request.getParameter("kcal")));
				bean.setDescription(request.getParameter("description"));
				menuList.set(index, bean);
				session.setAttribute("menuList", menuList);
				doGet(request, response);
			}
		}catch(Exception e) {
			request.setAttribute("message", "エラーが発生しました");
			doGet(request, response);
		}
	}
}
