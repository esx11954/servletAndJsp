package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

/**
 * サーブレットからDBにアクセスする際のインターフェース<br>
 * @author user
 *
 */
public interface DBAccess {

	/**
	 * DBへの操作を行うメソッド<br>
	 * 同パッケージのそれぞれのクラスがオーバーライドし<br>
	 * 検索、登録、更新、削除などの様々な処理を行う<br>
	 * @param request
	 * @throws SQLException
	 */
	public void execute(HttpServletRequest request) throws SQLException;
}
