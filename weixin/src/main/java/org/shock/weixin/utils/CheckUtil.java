package org.shock.weixin.utils;

import java.security.MessageDigest;
import java.util.Arrays;

import org.apache.tomcat.util.buf.HexUtils;

public class CheckUtil {
	public static boolean checksignature(String token,String signature,String timestamp,String nonce){
		try {
			System.out.println(String.format("signature[%s],timestamp[%s],nonce[%s]", signature,timestamp,nonce));
			String[] arr={token,timestamp,nonce};
			Arrays.sort(arr);
			StringBuffer sb = new StringBuffer();
			for (String str : arr) {
				sb.append(str);
			}
			MessageDigest md = MessageDigest.getInstance("sha1");
			md.update(sb.toString().getBytes());
			return HexUtils.toHexString(md.digest()).equals(signature);
		} catch (Exception e) {
		}
		return false;
	}
}
