package servise;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dto.MessageDto;

public class Select implements DBAccess {
	
	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		Dao dao = null;
		try {
			dao = new Dao();
			ArrayList<MessageDto> list = dao.getListAll();
			
			if(list != null) {
				request.setAttribute("list", list);
			}else {
				request.setAttribute("message", "まだデータがありません");
			}
		}finally {
			if(dao != null) dao.close();
		}
	}
}
