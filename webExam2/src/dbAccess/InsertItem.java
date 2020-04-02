package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.ItemDto;
import filter.Judge;

/**
 * DBAccessインターフェースを実装する登録クラス<br>
 * DBからパラメータに受取った商品情報を登録する<br>
 */
public class InsertItem implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		ItemDao dao = null;
		int n = 0;
		
		String name = request.getParameter("name");
		String category= request.getParameter("category");
		String price = request.getParameter("price");
		
		if(name != null && !name.isEmpty() && price != null && !price.isEmpty() && Judge.isNumber(price)) {
			
			ItemDto dto = new ItemDto();
			dto.setName(name);
			dto.setCategory(category);
			dto.setPrice(Integer.parseInt(price));
			dto.setCode(dto.hashCode());
			try {
				dao = new ItemDao();
				n = dao.insert(dto);
				if(n > 0) {
					request.setAttribute("message", "新規商品の登録が完了しました");
				}else {
					request.setAttribute("message", "商品の登録に失敗しました");
				}
			}finally {
				if(dao != null) dao.close();
			}
		}else {
			request.setAttribute("message", "入力が不正です");
		}
	}

}
