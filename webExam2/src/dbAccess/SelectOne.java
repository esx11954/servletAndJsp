package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.ItemDto;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * DBからパラメータに受取った商品コードの商品を一件のみ検索する<br>
 */
public class SelectOne implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		ItemDao dao = null;
		int code = Integer.parseInt(request.getParameter("code"));
		
		try {
			dao = new ItemDao();
			ItemDto dto = dao.getItem(code);
			request.setAttribute("item", dto);
		}finally {
			if(dao != null) dao.close();
		}
	}

}
