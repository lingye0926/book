package com.atguigu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.User;
import com.atguigu.utils.WebUtils;
import com.atuigu.service.UserService;
import com.atuigu.service.impl.UserServiceImpl;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	
	protected void login(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
//		String password = req.getParameter("password");
		User userLogin = userService.userLogin(WebUtils.copyParamToBean(req.getParameterMap(), new User()));
		if(userLogin != null) {
			req.getSession().setAttribute("user", userLogin);
			req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "用户名或者密码错误");
			req.setAttribute("username",username);
			req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
		}
	}
	
	protected void regist(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//获取Session中的验证码
		String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String code = req.getParameter("code");
		if(token != null && token.equalsIgnoreCase(code)) {
			boolean existsUsername = userService.existsUsername(username);
			if(existsUsername) {
				req.setAttribute("msg", "用户名已存在");
				req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
				
			}else {
				req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
			}
			
		}else {
			req.setAttribute("msg", "验证码错误");
			req.setAttribute("username", username);
			req.setAttribute("email", email);
			req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
			
		}
		
	}
	protected void logout(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect("index.jsp");
	
	}
}
