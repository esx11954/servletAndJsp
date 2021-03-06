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

/**
 * Bean追加用サーブレット
 */
@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// edit.jspの表示情報を準備
		request.setAttribute("servlet", "AddMenuServlet");
		request.setAttribute("editOrAdd", "入力");

		// edit.jspに遷移
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/edit.jsp");
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
		
		try {
			// 追加アイテムのパラメータを受取る
			String name = request.getParameter("foodName");
			String price = request.getParameter("price");
			String kcal = request.getParameter("kcal");
			String desc = request.getParameter("description");
			
			// 入力が不正なら例外発生
			if(name.isEmpty() || price.isEmpty() || kcal.isEmpty() || desc.isEmpty()) throw new Exception();
			
			// 正しく入力されていればsessionのmenuListに追加
			ArrayList<FoodBean> menuList = (ArrayList<FoodBean>) session.getAttribute("menuList");
			FoodBean foodBean = new FoodBean();
			foodBean.setFoodName(name);
			foodBean.setPrice(Integer.parseInt(price));
			foodBean.setKcal(Integer.parseInt(kcal));
			foodBean.setDescription(desc);
			menuList.add(foodBean);
			session.setAttribute("menuList", menuList);
		}catch(Exception e) {
			session.setAttribute("message", "エラーが発生しました");
			System.out.println(e.getMessage());
		}finally {
			response.sendRedirect("http://localhost:8080/beans/BeansServlet");
		}
	}
}
