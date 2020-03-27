package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.ItemDto;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * DBからパラメータに受取った価格帯の商品情報をArrayListとして取得する<br>
 */
public class SelectPrice implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {

		ItemDao dao = null;
		int price = Integer.parseInt(request.getParameter("price"));
		int p1 = 0;
		int p2 = 0;
		boolean flag = false;
		
		switch(price) {
		case 0:
			p2 = 1500;
			break;
		case 1:
			p1 = 1500;
			p2 = 3000;
			break;
		case 2:
			p1 = 3000;
			p2 = 5000;
			break;
		case 3:
			p1 = 5000;
			p2 = 10000;
			break;
		case 4:
			flag = true;
			break;
		}
		
		try {
			dao = new ItemDao();
			ArrayList<ItemDto> list = null;
			if(flag) {
				list = dao.getItemsMoreThan10000();
			}else {
				list = dao.getItemsFromPrice(p1, p2);
			}
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
