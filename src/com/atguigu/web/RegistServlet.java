package com.atguigu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.User;
import com.atuigu.service.UserService;
import com.atuigu.service.impl.UserServiceImpl;



public class RegistServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String code = req.getParameter("code");
		
		if("abcde".equalsIgnoreCase(code)) {
			boolean existsUsername = userService.existsUsername(username);
			
			if(existsUsername) {
				req.setAttribute("msg", "用户名已存在");
				System.out.println("用户名"+ username +"已存在");
				req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
			}else {
				userService.registUser(new User(null,username,password,email));
				req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
			}
			
		}else {
			
			req.setAttribute("msg", "验证码错误");
			req.setAttribute("email", email);
			req.setAttribute("username", username);
			System.out.println("验证码"+ code + "错误");
			req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
		}

	}

	

}
