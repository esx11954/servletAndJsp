package filter;

public class Judge {

	/**
	 * 数値判定メソッド<br>
	 * 引数に受け取った値が数値に変換できなければ例外発生
	 * @param num (パラメータ)
	 * @return 数値...true, 文字列...false 
	 */
	public static boolean isNumber(String num) {
	    try {
	        Integer.parseInt(num);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
