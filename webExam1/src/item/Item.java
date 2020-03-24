package item;

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
