package com.atguigu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.User;
import com.atuigu.service.UserService;
import com.atuigu.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		User loginUser = userService.userLogin(new User(null,username,password,null));
		if(loginUser != null) {
			
			req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "用户名或密码错误");
			req.setAttribute("username", username);
			req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
		}
		
	}
	

}
