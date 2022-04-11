package com.atguigu.test;

import org.junit.Test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;

public class UserDaoImplTest {
	
	
	@Test
	public void testQueryUserByUsername() {
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.queryUserByUsername("admin"));
		
	}
	
	@Test
	public void testQueryUserByUsernameAndPassword() {
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.queryUserByUsernameAndPassword("wangyi", "admin"));
	}
	
	@Test
	public void saveUser() {
		UserDao userDao = new UserDaoImpl();
		User user = new User(null,"wzg168","wzg168","wzg168@168.com");
		int saveUser = userDao.saveUser(user);
		System.out.println(saveUser);
	}

}
