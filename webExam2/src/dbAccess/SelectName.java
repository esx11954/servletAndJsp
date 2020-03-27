package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.ItemDto;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * DBからパラメータに受取った商品名の商品情報をArrayListとして取得する<br>
 */
public class SelectName implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {

		ItemDao dao = null;
		String name = request.getParameter("name");
		System.out.println(name);
		
		try {
			if(name != null && !name.isEmpty() ) {
				dao = new ItemDao();
				ArrayList<ItemDto> list = dao.getItemsFromName(name);
				if(list.size() > 0) {
					request.setAttribute("list", list);
				}else {
					request.setAttribute("message", "該当するデータがありません");
				}
			}else {
				request.setAttribute("message", "入力が不正です");
			}
		}finally {
			if(dao != null) dao.close();
		}

	}

}
