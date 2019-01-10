package org.shock.weixin.utils;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class WXMsgCrypt {
	public static String decrypt(String text,String appid,String encodingaeskey){
		try {
			Cipher c = Cipher.getInstance("AES/CBC/NoPadding");
			byte[] aseKey=Base64.decodeBase64(encodingaeskey+"=");
			SecretKeySpec key = new SecretKeySpec(aseKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aseKey, 0, 16));
			c.init(Cipher.DECRYPT_MODE, key,iv);
			byte[] encrypted = Base64.decodeBase64(text);
			byte[] original = c.doFinal(encrypted);
			int p=original[original.length-1];
			if(p<1||p>32){
				p=0;
			}
			byte[] bytes=Arrays.copyOfRange(original, 0, original.length-p);
			byte[] network=Arrays.copyOfRange(bytes, 16, 20);
			int sourceNumber=0;
			for (int i = 0; i < 4; i++) {
				sourceNumber <<= 8;
				sourceNumber |= network[i] & 0xff;
			}
			int xmlLength = sourceNumber;
			String xml = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength));
			String appid_=new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length));
			if(!appid_.equals(appid)){
				throw new Error("appid²»Ò»Ñù");
			}
			return xml;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
