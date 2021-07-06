package sp.spring.io.shop.security.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Md5Util {

	public static Md5Util singletonInstance = null;
//	private String data;

	public Md5Util() {
		super();
	}

	public static Md5Util getInstance() {
		if (singletonInstance == null) {
			return new Md5Util();
		}
		return singletonInstance;
	}

	public String getMd5Hash(String data) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(data.getBytes());
		byte[] digest = md.digest();
		String hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
		return hash;

	}

}
