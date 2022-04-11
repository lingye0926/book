package com.atguigu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.utils.JdbcUtils;

public class BaseDao {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	//update方法用来执行insert/update/delete操作
	//如果返回-1说明执行失败，返回其他表示影响的行数
	public int update(String sql, Object...args){
		Connection conn = JdbcUtils.getConnection();
		
		try {
			return  queryRunner.update(conn,sql,args);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return -1;
	}
	
	//查询一个对象的情况,返回一个Javabean
	public <T> T queryforone(Class<T> type, String sql,Object...args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new BeanHandler<T>(type),args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return null;
	}
	
	//查询多条对象记录的情况。返回一个list
	
	public <T> List<T>  queryList(Class<T> type,String sql,Object ...args){
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return null;
	}
	
	//查询返回一行一列统计查询的情况。
	public Object queryForSinglevalue(String sql,Object ...args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return queryRunner.query(conn,sql, new ScalarHandler<Object>(), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return null;
		
	}
}
