package cookieService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

/**
 * 第一引数が値、代二引数の名前のクッキーを生成するクラス
 * @author user
 *
 */
public class CookieFac {

	/**
	 * クッキー生成メソッド
	 * @param param (クッキーの値)
	 * @param idOrPass (クッキー名)
	 * @return 生成したクッキー
	 * @throws UnsupportedEncodingException
	 */
	public static Cookie getCookie(String param, String idOrPass) throws UnsupportedEncodingException {
		
		Cookie cookie = null;
		
		if(param != null && !param.isEmpty()) {
			
			// ここに処理を記入してください
			
		}
		return cookie;
	}
}
