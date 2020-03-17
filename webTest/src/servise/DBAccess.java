package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface DBAccess {
	public void excute(HttpServletRequest request) throws SQLException;
}
