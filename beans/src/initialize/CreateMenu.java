package initialize;

import java.util.ArrayList;

import bean.FoodBean;

/**
 * メニュー初期化のためのクラス<br>
 * createMenuListメソッドのみpublicなクラスメソッド
 * @author user
 *
 */
public class CreateMenu {

	/**
	 * メニュー名を持つ配列
	 */
	private static String[] names = {
		"ラーメン",
		"チャーハン",
		"餃子(6個)",
		"ピザ",
		"パスタ",
		"麻婆豆腐",
		"パエリア"
	};
	
	/**
	 * 値段を持つ配列
	 */
	private static int[] prices = {
		700,
		400,
		280,
		1080,
		810,
		580,
		640
	};
	
	/**
	 * カロリーを持つ配列
	 */
	private static int[] kcals = {
		436,
		163,
		196,
		266,
		149,
		307,
		129
	};
	
	/**
	 * 説明を持つ配列
	 */
	private static String[] descriptions = {
		"中華麺とスープを主とし、様々な具（チャーシュー、メンマ、味付け玉子、刻み葱、海苔など）を組み合わせた麺料理",
		"炊きあがった米飯を様々な具材と共に油で炒めた料理",
		"小麦粉を原料とした皮で、肉、エビ、野菜などで作った餡を包み、茹でる、焼く、蒸す、揚げるなど調理した食べ物",
		"小麦粉、水、塩、イースト、砂糖、少量のオリーブ油をこねた後に発酵させて作った生地を丸く薄くのばし、その上に具を乗せ、オーブンや専用の竃などで焼いた食品",
		"イタリア語でマカロニ、ペンネ、スパゲッティ、ラザニア、などの食品の総称",
		"挽肉と赤唐辛子・花椒（ホアジャオ、山椒の同属異種)・豆板醤（トウバンジャン、豆瓣醤）、トウチ（豆豉）などを炒め、鶏がらスープを入れ豆腐を煮た料理",
		"米（ジャバニカ米）どころとして知られるスペイン東部バレンシア地方発祥の、ジャバニカ米と野菜、魚介類、肉などの食材と共にそのスープを米に炊き込む料理"
	};
	
	/**
	 * メニューリストを生成するメソッド<br>
	 * beanオブジェクトにそれぞれのフィールドを代入し、<br>
	 * 配列の要素番号ごとに商品がオブジェクトとして生成される
	 * 
	 * @return　beanオブジェクトを要素としてもつArrayList
	 */
	public static ArrayList<FoodBean> createMenuList(){
		ArrayList<FoodBean> menuList = new ArrayList<>();
		FoodBean bean;
		for(int i = 0; i < names.length; i++) {
			bean = new FoodBean();
			bean.setFoodName(names[i]);
			bean.setPrice(prices[i]);
			bean.setKcal(kcals[i]);
			bean.setDescription(descriptions[i]);
			menuList.add(bean);
		}
		return menuList;
		
	}
	
}
