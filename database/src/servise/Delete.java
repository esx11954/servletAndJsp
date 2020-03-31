package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;

/**
 * DBAccessインターフェースを実装する削除クラス<br>
 * DBからパラメータに受取ったIDのデータを削除する
 * @author user
 *
 */
public class Delete implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {

		Dao dao = null;
		String id = request.getParameter("id");
		
		try {
			dao = new Dao();
			if(dao.deleteData(id) > 0) {
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
