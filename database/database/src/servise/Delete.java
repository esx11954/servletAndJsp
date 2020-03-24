package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;

public class Delete implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {

		Dao dao = null;
		String index = request.getParameter("index");
		
		try {
			dao = new Dao();
			if(dao.deleteData(index) > 0) {
				request.setAttribute("message", "削除完了！");
				System.out.println("Delete seccess!");
			}else {
				request.setAttribute("message", "削除失敗...");
				System.out.println("Delete failed...");
			}
		}finally {
			if(dao != null) dao.close();
		}
		

	}

}
