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
	
	/**
	 * DB接続コンストラクタ<br>
	 * インスタンス化時にDB接続が行われる
	 * @throws SQLException
	 */
	public Dao() throws SQLException{
		String url= "jdbc:mysql://localhost:3306/javaweb?serverTimezone=UTC";
		String user = "root";
		String pass = "root";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("Connection success!");
	}
	
	/**
	 * DB接続を切るためのメソッド
	 */
	public void close() {
		try {
			if(con != null) con.close(); 
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * DBに保存されているデータを全件取得するメソッド<br>
	 * DBから取得後、件数分のdtoに1レコードずつ情報を持たせてしてArrayListに格納<br>
	 * @return ID列で降順にソートしたArrayList
	 * @throws SQLException
	 */
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
	
	/**
	 * データ登録メソッド<br>
	 * SQL文とパラメータをexecuteUpdateメソッドに渡す
	 * @param input (受け取った入力値)
	 * @return 成功件数
	 * @throws SQLException
	 */
	public int insertData(String input) throws SQLException{
		String sql = "INSERT INTO tweet (content) VALUES (?)";
		return executeUpdate(sql, input);
	}
	
	/**
	 * データ削除メソッド<br>
	 * SQL文とパラメータをexecuteUpdateメソッドに渡す
	 * @param id (削除するデータのid)
	 * @return 成功件数
	 * @throws SQLException
	 */
	public int deleteData(String id) throws SQLException {
		String sql = "delete from tweet where id = ?";
		return executeUpdate(sql, id);
	}
	
	/**
	 * 登録、削除処理を担当するメソッド<br>
	 * 使用するメソッドは共通のため汎用化
	 * @param sql (SQL文)
	 * @param param (INパラメータ)
	 * @return 成功件数
	 * @throws SQLException
	 */
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
	
	/**
	 * 数値判定メソッド<br>
	 * 引数に受け取った値が数値に変換できなければ例外発生
	 * @param num (パラメータ)
	 * @return 数値...true, 文字列...false 
	 */
	private boolean isNumber(String num) {
	    try {
	        Integer.parseInt(num);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
