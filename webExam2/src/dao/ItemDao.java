package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ItemDto;

/**
 * DBとの接続、操作、切断を処理するクラス<br>
 * Dao...Data Access Objectの略
 * @author user
 *
 */
public class ItemDao {

	private Connection con;
	private String sql;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<ItemDto> list = null;
	
	/**
	 * testdbに接続するためのコンストラクタ
	 * @throws SQLException
	 */
	
	// ここにコンストラクタを記入してください
	
	
	/**
	 * DB接続を切断する
	 */
	public void close() {
		try {
			if(con != null) con.close(); 
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ログイン時のデータ照合
	 * @param name 名前
	 * @param pass　パスワード
	 * @return ログイン成功時...1 <br>ログイン失敗時...0
	 * @throws SQLException
	 */

	// ここにgetLoginInfoメソッドを記入してください
	
	/**
	 * DBから全データを抽出する
	 * @return 全データを保持するリスト
	 * @throws SQLException
	 */
	
	// ここにgetItemsAllメソッドを記入してください

	/**
	 * DBから1レコードを抽出する(商品コードで検索)
	 * @param code 抽出したい商品コード
	 * @return 該当データ
	 * @throws SQLException
	 */
	public ItemDto getItem(int code) throws SQLException{
		
		sql = "select * from item where code = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, code);
		return search(ps).get(0);
	}
	
	/**
	 * DBから名前検索
	 * @param name 商品名
	 * @return 名前検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */
	public ArrayList<ItemDto> getItemsFromName(String name) throws SQLException{
		
		sql = "select * from item where name like ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, "%" + name + "%");
		return search(ps);
	}
	
	/**
	 * DBからカテゴリ検索
	 * @param category カテゴリ名
	 * @return カテゴリ検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */
	public ArrayList<ItemDto> getItemsFromCategroy(String category) throws SQLException{
		
		sql = "select * from item where category = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, category);
		return search(ps);
	}
	
	/**
	 * DBから範囲指定の値段検索
	 * @param p1 最低値
	 * @param p2 最高値
	 * @return 値段検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */
	public ArrayList<ItemDto> getItemsFromPrice(int p1, int p2) throws SQLException{
		
		sql = "select * from item where price between ? and ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, p1);
		ps.setInt(2, p2);
		return search(ps);
	}
	
	/**
	 * DBから10,000円以上の値段検索
	 * @return 検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */
	public ArrayList<ItemDto> getItemsMoreThan10000() throws SQLException{
		sql = "select * from item where price >= 10000";
		ps = con.prepareStatement(sql);
		return search(ps);
	}
	
	/**
	 * select文を実行するメソッド
	 * @param ps パラメータがセットされたSQLを持つオブジェクト
	 * @return 検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */

	// ここにsearchメソッドを記入してください
	
	/**
	 * 画面から受け取ったデータをDBに挿入するメソッド
	 * @param dto (パラメータをまとめてもつオブジェクト)
	 * @return 成功件数
	 * @throws SQLException
	 */

	// ここにinsertメソッドを記入してください
	
	/**
	 * DBへの更新処理
	 * @param dto 既存商品の更新情報を持つオブジェクト
	 * @return 成功件数
	 * @throws SQLException
	 */
	
	// ここにupdateメソッドを記入してください
	
	/**
	 * DBへの削除処理
	 * @param code 商品コード
	 * @return 成功件数
	 * @throws SQLException
	 */

	// ここにdeleteメソッドを記入してください
	
	/**
	 * カテゴリを変換するメソッド
	 * @param category DB用カテゴリ名
	 * @return 画面用カテゴリ名
	 */
	private String parseCategory(String category) {
		
		String ctgr = null;
		
		switch(category) {
		case "general":
			ctgr = "雑貨";
			break;
		case "electric":
			ctgr = "家電";
			break;
		case "book":
			ctgr = "書籍";
			break;
		case "food":
			ctgr = "食品";
			break;
		case "fashion":
			ctgr = "ファッション";
			break;
		default:
			ctgr = "未分類";	
		}
		
		return ctgr;
	}
}
