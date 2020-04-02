package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * DBからパラメータに受取ったID,パスワードを照合する<br>
 */
public class SelectForLogin implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		ItemDao dao = null;
		int n = 0;
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if(name == null || name.isEmpty() || pass == null || pass.isEmpty()) {
			request.setAttribute("message", "ユーザ名、パスワードを入力してください");
			request.setAttribute("flag", false);
			return;
		}
		
		try {
			dao = new ItemDao();
			n = dao.getLoginInfo(name, pass);

			if(n > 0) {
				request.setAttribute("flag", true);
			}else {
				request.setAttribute("flag", false);
			}
		}finally {
			if(dao != null) dao.close();
		}

	}

}
