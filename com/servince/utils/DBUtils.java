package com.servince.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	String url = "";
	String user = "";
	String password = "";
		//提供私有的构造方法
		private DBUtils(){
			Properties prop = new Properties();
			try {
				prop.load(this.getClass().getResourceAsStream("db.properties"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				Class.forName(prop.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			//获取与数据库的连接 
			url = prop.getProperty("url"); // 用指定的键在此属性列表中搜索属性
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
		}
		
		//私有的静态的实例化对象
		private static DBUtils dbUtils = new DBUtils();
		
		//提供给外部获取对象的方法
		public  static DBUtils getInstance(){
			return dbUtils;
		}
		//获取数据库连接的方法
		public Connection getConn(){
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		
		//开启事务的方法
		public static void beginTransaction(Connection conn){
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//提交
		public static void  commit(Connection conn ){
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//回滚
		public static void  rollback(Connection conn ){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}
