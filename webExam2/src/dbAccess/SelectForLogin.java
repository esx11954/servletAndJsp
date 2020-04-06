package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * DBからパラメータに受取ったID,パスワードを照合する<br>
 */
public class SelectForLogin implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		// ここに処理を記入してください
		int n = 0;
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if(name == null || name.isEmpty() || pass == null || pass.isEmpty()) {
			request.setAttribute("message", "ユーザ名、パスワードを入力してください");
			request.setAttribute("flag", false);
			return;
		}
		
		try {
			// ここに処理を記入してください
			// ここに処理を記入してください
			
			if(n > 0) {
				request.setAttribute("flag", true);
			}else {
				request.setAttribute("flag", false);
			}
		}finally {
			// ここに処理を記入してください
		}

	}

}
