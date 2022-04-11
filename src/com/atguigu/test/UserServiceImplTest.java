package com.atguigu.test;

import org.junit.Test;

import com.atguigu.pojo.User;
import com.atuigu.service.UserService;
import com.atuigu.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	
	UserService userService = new UserServiceImpl();
	
	@Test
	public void registUser() {
		User user = new User(null,"wangyibo","wangyibo18","wangyibo@126.com");
		userService.registUser(user);
		
	}
	
	@Test
	public void userLogin() {
		User user = new User(null,"wangyi","wangyibo18","wangyibo@126.com");
		userService.userLogin(user);
	}
	
	
	@Test
	public void existsUsername() {
		boolean existsUsername = userService.existsUsername("wangyibo");
		System.out.println(existsUsername);
	}

}
