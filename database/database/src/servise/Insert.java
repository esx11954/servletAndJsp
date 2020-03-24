package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;

public class Insert implements DBAccess {

	public void execute(HttpServletRequest request) throws SQLException {
		
		Dao dao = null;
		String input = request.getParameter("text");
		
		try {
			dao = new Dao();
			if(dao.insertData(input) > 0) {
				request.setAttribute("message", "投稿完了！");
				System.out.println("Insert seccess!");
			}else {
				request.setAttribute("message", "投稿失敗...");
				System.out.println("Insert failed...");
			}
		}finally {
			if(dao != null) dao.close();
		}
	}
}
