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

import item.Item;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ArrayList<Item> list = new ArrayList<Item>();
	
	static {
		list.add(new Item("北海道", 22000, "hokkaidou.jpg"));
		list.add(new Item("東京", 15000, "tokyo.jpg"));
		list.add(new Item("名古屋", 12000, "nagoya.jpg"));
		list.add(new Item("大阪", 14000, "osaka.jpg"));
		list.add(new Item("沖縄", 23000, "okinawa.jpg"));
	} 
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("list", list);
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/shopForm.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String btn = request.getParameter("btn");
		String jsp = "";

		if(btn.equals("送信")) {
			int total = 0;
			int index = 0;
			
			try {
				index = Integer.parseInt(request.getParameter("itemIndex"));
			}catch(NumberFormatException e) {
				doGet(request, response);
				return;
			}
			Item item = list.get(index);
			int count = Integer.parseInt(request.getParameter("count"));
			
			if(count >= 4) {
				total = (int) (item.getPrice() * count * 0.9);
				request.setAttribute("message", "10%OFF");
			}else {
				total = item.getPrice() * count;
			}
			request.setAttribute("total", total);
			request.setAttribute("count", count);
			request.setAttribute("item", item);
			jsp = "/shopConfirm.jsp";
			
		}else if(btn.equals("はい")){
			jsp = "/shopDone.jsp";
		}else {
			doGet(request, response);
			return;
		}
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher(jsp);
		dis.forward(request, response);
	}
}
