package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import dto.MessageDto;

public class Dao {

	private Connection con;
	private String sql;
	
	public Dao() throws SQLException{
		String url= "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
		String user = "root";
		String pass = "root";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("Connection success!");
	}
	
	public void close() {
		try {
			if(con != null) con.close(); 
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<MessageDto> getListAll() throws SQLException{
		
		sql = "select * from tweet";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MessageDto> list = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			MessageDto dto;
			while(rs.next()) {
				dto = new MessageDto();
				dto.setId(rs.getInt("id"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getString("date"));
				list.add(dto);
			}
			rs.close();
		}finally {
			ps.close();
		}
		Comparator<MessageDto> comparator = Comparator.comparing(MessageDto::getId).reversed();
		
		return (ArrayList<MessageDto>) list.stream().sorted(comparator).collect(Collectors.toList());	
	}
	
	public int insertData(String input) throws SQLException{

		String sql = "INSERT INTO tweet (content) VALUES (?)";
		return executeUpdate(sql, input);
	}
	
	public int deleteData(String index) throws SQLException {
		
		String sql = "delete from tweet where id = ?";
		return executeUpdate(sql, index);
	}
	
	private int executeUpdate(String sql, String param) throws SQLException {
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			ps = con.prepareStatement(sql);
			
			if(isNumber(param)) ps.setInt(1, Integer.parseInt(param));
			else ps.setString(1, param);
			
			n = ps.executeUpdate();
		}finally {
			ps.close();
		}
		return n;
	}
	
	private boolean isNumber(String num) {
	    try {
	        Integer.parseInt(num);
	        return true;
	        } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
