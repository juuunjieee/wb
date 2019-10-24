package com.ulwx.listener;

import com.ulwx.database.dbpool.DBPoolFactory;
import com.ulwx.database.sql.SqlUtils;
import com.ulwx.tool.MemoryLeakCleanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextListener implements ServletContextListener {
	private  Logger log = LoggerFactory.getLogger(ContextListener.class);
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//CachedClientFactory.clearAll();
	
		try{    
			DBPoolFactory.getInstance().clearAll();      
			MDC.clear();
			MemoryLeakCleanUtil.clearThreadLocals();
			MemoryLeakCleanUtil.CleanMysqlDriver(this.getClass());
			SqlUtils.clearDbDriver();
			com.mysql.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();

			
		}catch(Exception e){
			log.error("",e);
		}
	}

	public void contextInitialized(ServletContextEvent se) {

		try{
			DBPoolFactory.init();
//			JmsPoolFactory.init();
		
		}catch(Exception e){
			log.error("",e);
		}
	}

}
