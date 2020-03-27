package dto;

/**
 * 商品データを保持するクラス<br>
 * データ検索時のデータ管理やデータ登録時の際にも使用され、以下のフィールドを持つ<br>
 * ・商品ID<br>
 * ・商品名<br>
 * ・商品コード<br>
 * ・カテゴリ<br>
 * ・値段<br>
 * @author user
 *
 */
public class ItemDto {

	/**
	 * 商品ID
	 */
	int id;
	
	/**
	 * 商品コード
	 */
	int code;
	
	/**
	 * 商品名
	 */
	String name;
	
	/**
	 * カテゴリ
	 */
	String category;
	
	/**
	 * 値段
	 */
	int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
