package com.atguigu.test;

import java.sql.Connection;

import org.junit.Test;

import com.atguigu.utils.JdbcUtils;

public class JdbcUtilsTest {
	
	@Test
	public void test1() {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
