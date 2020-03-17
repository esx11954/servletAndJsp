package cookieService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

public class CookieFac {

	public static Cookie getCookie(String param, String idOrPass) throws UnsupportedEncodingException {
		
		Cookie cookie = null;
		System.out.println("param..." + param);
		if(param != null && !param.isEmpty()) {
			String encoded = URLEncoder.encode(param, "UTF-8");
			cookie = new Cookie(idOrPass, encoded);
			cookie.setMaxAge(60);
		}
		return cookie;
	}
}
