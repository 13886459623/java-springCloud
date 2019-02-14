package com.ycb.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

public class StringUtil {
	public static final StringUtil stringUtils = new StringUtil();

	public static StringUtil getStringutils() {
		return stringUtils;
	}

	/**
	 * 
	 * <p class="detail">
	 * �ж��ַ��Ƿ�Ϊ���ַ���null
	 * </p>
	 * @author <a href="mailto:qinhailong@wokejia.com ">�غ���</a> 2013-5-16 ����10:37:31
	 * @param s
	 * @return
	 */
	public static boolean isEntity(String s) {
		return (s == null || "".equals(s) ? false : true);
	}

	/**
	 * <p class="detail">
	 * ������ж�,֧��:
	 * <br>1.�ַ�		{"":true," ":false}
	 * <br>2.Collection	{new ArrayList():true,new HashSet():true} 
	 * <br>3.Map		{new HasMap():true}
	 * </p>
	 * @author <a href="mailto:chenming@wokejia.com ">����</a> 2013-5-16 ����11:06:38
	 * @param object	�ж϶��� 
	 * @return    
	 */
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String) {
			return ((String) object).isEmpty();
		} else if (object instanceof Collection) {
			return ((Collection<?>) object).isEmpty();
		} else if (object instanceof Map) {
			return ((Map<?, ?>) object).isEmpty();
		} else {
			return false;
		}
	}

	/**
	 * <p class="detail">
	 * ����ǿ��жϣ�֧��:
	 * <br>1.Object {null:false}
	 * <br>2.String {"":false," ":true}
	 * </p>
	 * @author <a href="mailto:chenming@wokejia.com ">����</a> 2013-5-16 ����11:30:44
	 * @param object	�Ƚ϶���
	 * @return
	 * @see com.wokejia.crm.util.StringUtil#isEmpty
	 */
	public static boolean isNotEmpty(Object object) {
		if (object == null) {
			return false;
		}
		if (object instanceof String) {
			return !((String) object).isEmpty();
		} else {
			return true;
		}
	}

	/**
	 * <p class="detail">
	 * ��Ϣ��ʽ��
	 * </p>
	 * @author <a href="mailto:chenming@wokejia.com ">����</a> 2013-6-8 ����9:47:39
	 * @param pattern	��Ϣ��ʽ
	 * @param arguments	����
	 * @return
	 */
	public static String format(String pattern, Object... arguments) {
		return java.text.MessageFormat.format(pattern, arguments);
	}

	/**
	 * <p class="detail">
	 * �ϸ�Ƚ�����}�ַ�����Ƿ����
	 * ����һ��Ϊnull.����}��ͬΪnull,ҲΪ��ͬ
	 * </p>
	 * @author <a href="mailto:chenming@wokejia.com ">����</a> 2013-6-24 ����4:08:12
	 * @return
	 */
	public static boolean strictCompare(String str, String other) {
		if (str == null || other == null) {
			return false;
		}
		return str.equals(other);
	}

	/**
	 * <p class="detail">
	 * ��UTF-8�����ַ�
	 * </p>
	 * @author <a href="mailto:chenming@wokejia.com ">����</a> 2013-6-24 ����4:31:22
	 * @param str
	 * @return
	 */
	public static String encodeURL(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
	}
}
