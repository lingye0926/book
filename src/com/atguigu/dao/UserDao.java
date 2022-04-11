package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao{
	//注册功能
	//根据用户名查询用户信息
	public User queryUserByUsername(String username);
	
	//保存用户信息
	public int saveUser(User user);
	
	
	
	//登录功能
	//根据用户名和密码查询用户信息
	public User queryUserByUsernameAndPassword(String username,String password);
	
	
}
