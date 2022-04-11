package com.atguigu.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atuigu.service.OrderService;
import com.atuigu.service.impl.OrderServiceImpl;

public class OrderServiceImplTest {
	OrderService orderService = new OrderServiceImpl();

	@Test
	public void testCreateorder() {
		Cart cart = new Cart();
		cart.addItem(new CartItem(1,"Excel从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
		cart.addItem(new CartItem(1,"VBA从入门到放弃",3,new BigDecimal(1000),new BigDecimal(100)));
		cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(10),new BigDecimal(100)));
		String orderId = orderService.createOrder(cart, 1);
		System.out.println("订单号是：" + orderId);
	}
	
	@Test
	public void testShowMyOrders() {
		List<Order> myOrders = orderService.showMyOrders(1);
		System.out.println(myOrders);
	}
	
	@Test
	public void testShowAllOrders() {
		List<Order> allOrders = orderService.showAllOrders();
		System.out.println(allOrders);
	}

}
