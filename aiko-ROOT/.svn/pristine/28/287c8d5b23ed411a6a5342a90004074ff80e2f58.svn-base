package com.ycb.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	  public static String hex(byte[] array)  {
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
	        }
	        return sb.toString();
	    }

	    public static String md5(String message) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            return hex(md.digest(message.getBytes("CP1252")));
	        } catch (NoSuchAlgorithmException e) {

	        } catch (UnsupportedEncodingException e) {
	        
	        }
	        return message;
	    }
	    
	    public static void main(String[] args) {
	        // e10adc3949ba59abbe56e057f20f883e
	       System.out.println(Md5Util.md5("123456"));

	    }
}
