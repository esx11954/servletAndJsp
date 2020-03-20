package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface DBAccess {
	public void execute(HttpServletRequest request) throws SQLException;
}
