package com.yscf.admin.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class MyCache {



/**
   expireAfterWrite是在指定项在一定时间内没有创建/覆盖时，会移除该key，下次取的时候从loading中取
   expireAfterAccess是指定项在一定时间内没有读写，会移除该key，下次取的时候从loading中取
   refreshAfterWrite是在指定时间内没有被创建/覆盖，则指定时间过后，再次访问时，会去刷新该缓存，在新值没有到来之前，始终返回旧值
          跟expire的区别是，指定时间过后，expire是remove该key，下次访问是同步去获取返回新值；
          而refresh则是指定时间后，不会remove该key，下次访问会触发刷新，新值没有回来时返回旧值
*/

	private static Cache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(5000).
			expireAfterAccess(60, TimeUnit.MINUTES).expireAfterWrite(20, TimeUnit.MINUTES).build();  
//	private static Map<String,Object> cache=new ConcurrentHashMap<>();
	
	public static <T> void put(String key, T value){
		cache.put(key, value);
	}
	
	
	public static <T> T get(String key){
		return (T)cache.getIfPresent(key);
	}
	/**
	 * 根据key获取数据，如果获取不到，调用callback方法获取后去后，会自动塞进cache。用此方法，程序外面就不需要判断cache里的值是否存在，后再塞入cache的逻辑。
	 * @param key
	 * @param callback
	 * @return
	 * @throws Exception
	 */
	public static <T> T get(String key,Callable<T> callback)throws Exception{
		return (T)cache.get(key, callback);
	}
	

}
