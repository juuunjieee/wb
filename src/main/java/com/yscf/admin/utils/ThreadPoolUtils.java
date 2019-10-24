package com.yscf.admin.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtils {
	public static volatile ExecutorService pool=Executors.newFixedThreadPool(10);
	public static class Holder{
		 static {
			 //ThreadPoolUtils.pool=Executors.newFixedThreadPool(4);
		}
		public static void init() {
			
		}
	}
	
	public static void init() {
		ThreadPoolUtils.Holder.init();
	}
	
	public static void shutdown() {
		if(pool!=null) {
			pool.shutdown();
			pool=null;
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}



