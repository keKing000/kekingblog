package top.keking.utils;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Encoder;

public class MD5Util {

	/**
	 * 
	* @Title: md5
	* @Description: MD5加密 Base64编码
	* @param @param str
	* @param @return
	* @param @throws NoSuchAlgorithmException
	* @param @throws UnsupportedEncodingException    
	* @return String  生成24位字符串  
	* @throws
	 */
	public static String md5(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(str.getBytes("utf-8"));
			Encoder encoder = Base64.getEncoder();
			str = encoder.encodeToString(digest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
