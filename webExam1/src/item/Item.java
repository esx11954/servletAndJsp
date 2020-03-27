package item;

/**
 * ツアー情報をまとめて保持するためのクラス<br>
 * 以下をフィールドとして持つ<br>
 * ・ツアー名<br>
 * ・価格<br>
 * ・画像url<br>
 * コンストラクタがセッターの役割になっている
 * @author user
 *
 */
public class Item {
	
	// フィールド
	private String name;
	
	private int price;
	
	private String image;

	// コンストラクタ
	public Item(String name, int price, String image) {
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
	// ゲッター
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}
}
