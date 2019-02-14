package chinapay.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author gaoyan
 *
 */
public class Configread {

	private static Configread instance = null;
	
	private Properties properties = null;
	
	private Configread(InputStream is) {
		init(is);
	}
	
	public static Configread getInstance(InputStream is) {
		
		if (instance == null) {
			instance = new Configread(is);
		}
		return instance;
	}
	
	/**
	 * 初始化配置文件
	 */
	public void init(InputStream is){
		
		try{
			properties = new Properties();
			properties.load(is);
			
		}catch (Exception e){
			throw new RuntimeException("Failed to get properties!");
		}
	}
	
	/**
	 * 根据key值取得对应的value值
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}
}
