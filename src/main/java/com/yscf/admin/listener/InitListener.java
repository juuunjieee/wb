package com.yscf.admin.listener;

import com.ulwx.tool.http.MultiThreadHttpClient;
import com.yscf.admin.utils.ThreadPoolUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class InitListener implements ServletContextListener {
	private  Logger log = LoggerFactory.getLogger(InitListener.class);
	public void contextDestroyed(ServletContextEvent sce) {

	
		try{     
			MultiThreadHttpClient.shutdown();
			ThreadPoolUtils.shutdown();
			
		}catch(Exception e){
			log.error("",e);
		}
	}

	public void contextInitialized(ServletContextEvent se) {

		try{
			MultiThreadHttpClient.init();
			ThreadPoolUtils.init();
		
		}catch(Exception e){
			log.error("",e);
		}
	}

}
