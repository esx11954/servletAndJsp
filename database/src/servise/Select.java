package servise;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dto.MessageDto;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * 全てのデータをArrayListとして取得する
 * @author user
 *
 */
public class Select implements DBAccess {
	
	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		// ここに処理を記入してください
		
	}
}
