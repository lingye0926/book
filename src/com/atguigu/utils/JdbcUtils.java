package com.atguigu.utils;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JdbcUtils {
	
	private static DruidDataSource dataSource;
	
	
	
	static {
	
		try {
			Properties properties = new Properties();
			InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(inputStream);
			dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
//			System.out.println(dataSource);
		
		}  catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	//获取数据库链接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//关闭连接，放回数据库连接池
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	

}
