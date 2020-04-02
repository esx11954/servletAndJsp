package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.ItemDto;
import filter.Judge;

/**
 * DBAccessインターフェースを実装する更新クラス<br>
 * DBからパラメータに受取った商品コードの商品情報を更新する<br>
 */
public class UpdateItem implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		ItemDao dao = null;
		int n = 0;
		
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		
		if(name == null || name.isEmpty() || price == null || price.isEmpty() || !Judge.isNumber(price)) {
			request.setAttribute("message", "入力が不正です");
			return;
		}
		
		ItemDto dto = new ItemDto();
		dto.setCode(code);
		dto.setName(name);
		dto.setCategory(category);
		dto.setPrice(Integer.parseInt(price));
		
		try {
			dao = new ItemDao();
			n = dao.update(dto);
			if(n > 0) {
				request.setAttribute("message", "商品の編集が完了しました");
			}else {
				request.setAttribute("message", "商品の編集に失敗しました");
			}
		}finally {
			if(dao != null) dao.close();
		}

	}

}
