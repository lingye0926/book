package com.atuigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atuigu.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public void registUser(User user) {
		
		userDao.saveUser(user);
		
	}	

	@Override
	public User userLogin(User user) {
		return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		
	}

	@Override
	public boolean existsUsername(String username) {
		if(userDao.queryUserByUsername(username) != null) {
			return true;
		}
		return false;
	}

}
