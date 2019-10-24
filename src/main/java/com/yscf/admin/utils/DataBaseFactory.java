package com.yscf.admin.utils;

import com.ulwx.database.DataBase;
import com.ulwx.database.DbException;

public class DataBaseFactory {


	
	/**
	 * 用于从连接池构造DataBase对象，连接池配置文件在src目录下的dbpool.xml里
	 * @return
	 * @throws DbException
	 */
	public static DataBase getDataBase() throws DbException {
		DataBase db = new DataBase();
		try {
			db.connectDb("tt1");
//			 db.connectDb("gameuser", "jb98",
//		 "jdbc:mysql://localhost:10001/versiondb",
//			 "com.mysql.jdbc.Driver");
		} catch (DbException e) {
			throw new DbException("can't connect database!", e);
		}
		return db;

	}
	
	
	/**
	 * 
	 * @param dataSourceName 连接池的名字
	 * @return
	 * @throws DbException
	 */
	public static DataBase getDataBase(String dbPoolName) throws DbException {
		DataBase db = new DataBase();
		try {
			db.connectDb(dbPoolName);
//			 db.connectDb("gameuser", "jb98",
//		 "jdbc:mysql://localhost:10001/versiondb",
//			 "com.mysql.jdbc.Driver");
		} catch (DbException e) {
			throw new DbException("can't connect database!", e);
		}
		return db;

	}
	/**
	 * @param args
	 * @throws
	 */
	public static void main(String[] args) {
		
		
	}

}
