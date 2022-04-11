package com.atguigu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.utils.WebUtils;
import com.atuigu.service.BookService;
import com.atuigu.service.OrderService;
import com.atuigu.service.impl.BookServiceImpl;
import com.atuigu.service.impl.OrderServiceImpl;

public class OrderServlet extends BaseServlet{
	
	private OrderService orderService = new OrderServiceImpl();
	
	protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart cart = (Cart)req.getSession().getAttribute("cart");
		
		User user = (User)req.getSession().getAttribute("user");
		if(user == null) {
			req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
			return;
		}
		String orderNo = orderService.createOrder(cart, user.getId());
		req.getSession().setAttribute("orderNo", orderNo);
//		System.out.println("订单号：" + orderNo + "已保存");
		//为避免用户刷新页面重复提交，此处应使用重定向而不是请求转发
//		req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
	}
	protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Order> allOrders = orderService.showAllOrders();
		req.setAttribute("allOrders", allOrders);
		req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
		
	}
	protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderId = req.getParameter("orderId");
		orderService.sendOrder(orderId);
		resp.sendRedirect(req.getHeader("referer"));
	}
	protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderId = req.getParameter("orderId");
		List<OrderItem> orderItems = orderService.showOrderDetails(orderId);
//		System.out.println(orderItems);
		req.setAttribute("orderItems", orderItems);
		req.getRequestDispatcher("/pages/order/order_details.jsp").forward(req, resp);
	}
	protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("user");
		List<Order> myOrders = orderService.showMyOrders(user.getId());
		req.setAttribute("myOrders", myOrders);
		req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
	}
	protected void recieveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderId = req.getParameter("orderId");
		orderService.recieveOrder(orderId);
		resp.sendRedirect(req.getHeader("referer"));
	}

}
