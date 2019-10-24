package com.ulwxbase.listener;

import com.ulwx.tool.http.MultiThreadHttpClient;
import com.ulwxbase.utils.CbThreadPoolUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class InitListener implements ServletContextListener {
	private  Logger log = LoggerFactory.getLogger(InitListener.class);
	public void contextDestroyed(ServletContextEvent sce) {

	
		try{    
			MultiThreadHttpClient.shutdown();
			CbThreadPoolUtils.shutdown();
			
		}catch(Exception e){
			log.error("",e);
		}
	}

	public void contextInitialized(ServletContextEvent se) {

		try{
			MultiThreadHttpClient.MAX_CONNECTIONS=10;
			MultiThreadHttpClient.init();
			CbThreadPoolUtils.init();
		
		}catch(Exception e){
			log.error("",e);
		}
	}

}
