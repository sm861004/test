package com.safe.www.util;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 프로퍼티 Util
 * @author Bang Seok Min
 */
public class PropertiesBean {
	private static PropertiesBean instance;
	private static PropertiesConfiguration config = null;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * 설명 : 프로퍼티 인스턴스 생성 <br />
	 * 작성자 : Bang Seok Min <br />
	 * 작성일자 : 2017. 6. 15. <br />
	 * @param prop
	 * @return PropertiesBean
	 */
	public static PropertiesBean getInstance(String prop) {
		if(instance == null) 
			instance = new PropertiesBean(prop);
		
		return instance;
	}
	
	/**
	 * 프로퍼티 세팅
	 * @param prop
	 */
	public PropertiesBean(String prop){
		try {
			config = new PropertiesConfiguration(prop);
			config.setEncoding("UTF-8");
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
		} catch (Exception e) {
			logger.debug("PropertiesBean PropertiesBean error");
		}
	}
	
	/**
	 * 설명 : prop명 프로퍼티 Read<br />
	 * 작성자 : Bang Seok Min <br />
	 * 작성일자 : 2017. 6. 15. <br />
	 * @param prop
	 * @return String
	 */
	public String getProperty(String prop) {
		String sReturn = "";
		try {
			sReturn = config.getString(prop);
		} catch (Exception e) {
			logger.debug("PropertiesBean getProperty error");
		}
		return sReturn;
	}
	
	/**
	 * 설명 : config세팅 prop명 프로퍼티 Read<br />
	 * 작성자 : Bang Seok Min <br />
	 * 작성일자 : 2017. 6. 15. <br />
	 * @param prop
	 * @param configFile
	 * @return String
	 */
	public String getProperty(String prop, String configFile) {
		String sReturn = "";
		try {
			config = new PropertiesConfiguration(configFile);
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
			sReturn = config.getString(prop);
		} catch (Exception e) {
			logger.debug("PropertiesBean getProperty error");
		}
		return sReturn;
	}
}
