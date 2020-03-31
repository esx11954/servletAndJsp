package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;

/**
 * DBAccessインターフェースを実装する登録クラス<br>
 * パラメータに受取った入力値をDBに登録する
 * @author user
 *
 */
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
