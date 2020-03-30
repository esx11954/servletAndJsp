package bean;

import java.io.Serializable;


/**
 * 料理情報をまとめて保持するためのクラス<br>
 * 以下のフィールドを持つ<br>
 * ・料理名<br>
 * ・値段<br>
 * ・カロリー<br>
 * ・説明<br>
 * @author user
 *
 */
@SuppressWarnings("serial")
public class FoodBean implements Serializable {

	/**
	 * 料理名
	 * */
	String foodName;
	
	/**
	 * 値段
	 * */
	int price;
	
	/**
	 * カロリー
	 * */
	int kcal;
	
	/**
	 * 説明
	 * */
	String description;

	
	//以下ゲッター、セッター
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
