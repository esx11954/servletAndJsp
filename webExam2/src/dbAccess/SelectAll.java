package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.ItemDto;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * 全ての商品情報をArrayListとして取得する<br>
 */
public class SelectAll implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		ItemDao dao = null;
		
		try {
			dao = new ItemDao();
			ArrayList<ItemDto> list = dao.getItemsAll();
			if(list.size() > 0) {
				request.setAttribute("list", list);
			}else {
				request.setAttribute("message", "まだデータがありません");
			}
		}finally {
			if(dao != null) dao.close();
		}
	}
}
