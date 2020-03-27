package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.ItemDto;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * DBからパラメータに受取ったカテゴリの商品情報をArrayListとして取得する<br>
 */
public class SelectCategory implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		ItemDao dao = null;
		String category = request.getParameter("category");
		
		try {
			dao = new ItemDao();
			ArrayList<ItemDto> list = dao.getItemsFromCategroy(category);
			if(list.size() > 0) {
				request.setAttribute("list", list);
			}else {
				request.setAttribute("message", "該当するデータがありません");
			}
		}finally {
			if(dao != null) dao.close();
		}

	}

}
