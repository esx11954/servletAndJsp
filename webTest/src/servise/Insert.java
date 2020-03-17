package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;

public class Insert implements DBAccess {

	@Override
	public void excute(HttpServletRequest request) throws SQLException {
		
		Dao dao = null;
		String input = request.getParameter("text");
		
		try {
			dao = new Dao();
			if(dao.insertData(input) > 0) {
				request.setAttribute("message", "挿入完了！");
				System.out.println("Insert seccess!");
			}else {
				request.setAttribute("message", "挿入失敗...");
				System.out.println("Insert failed...");
			}
		}finally {
			if(dao != null) dao.close();
		}
	}
}
