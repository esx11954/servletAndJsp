package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProfileBean;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		if(session != null) session.invalidate();
		// System.out.println("get " + session.getId());
		
		if(request.getAttribute("message") == null) request.setAttribute("message", "名前とパスワードを入力してください");
				
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/top.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fileName = "top";
		String button = request.getParameter("button");
		
		
		System.out.println(button);
		
		HttpSession session = request.getSession(false);
		ProfileBean pBean = (ProfileBean) session.getAttribute("bean");
		
		System.out.println("post" + session.getId());
		
		// ログインボタンが押された場合
		if(button.equals("login")) {
			
			// ログイン成功時の処理
			if(request.getParameter("pass").equals("reglecasse")) {
				HttpSession newSession = request.getSession(true);
				pBean = new ProfileBean();
				pBean.setName(request.getParameter("name"));
				newSession.setAttribute("bean", pBean);
				fileName = "myPage";
				
			// ログイン失敗時の処理
			}else {
				request.setAttribute("message", "ログインに失敗しました");
				doGet(request, response);
				return;
			}
			
		// profileボタンが押された場合
		}else if(button.equals("profile") && pBean != null) {
			fileName = "ask1";
			
		// logoutボタンが押された場合
		}else if(button.equals("logout") && pBean != null) {
			request.setAttribute("message", "ログアウトしました");
			doGet(request, response);
			return;
			
		// nextボタンが押された場合
		}else if(button.equals("next") && pBean != null) {
			String askNo = request.getParameter("askNo");

			// ask1.jspから飛んできた場合
			if(askNo.equals("1")) {
				pBean.setAge(request.getParameter("age"));
				session.setAttribute("bean", pBean);
				fileName = "ask2";
				
			// ask2.jspから飛んできた場合
			}else if(askNo.equals("2")) {
				pBean.setGender(request.getParameter("gender"));
				session.setAttribute("bean", pBean);
				System.out.println(request.getParameter("gender"));
				fileName = "myPage";
			}
			
		// 不正な操作が行われた場合
		}else {
			request.setAttribute("message", "セッションが不正です");
			doGet(request, response);
			return;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/" + fileName + ".jsp");
		dis.forward(request, response);
	}
}
