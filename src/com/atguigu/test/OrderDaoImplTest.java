package com.atguigu.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

public class OrderDaoImplTest {
	OrderDao orderDao = new OrderDaoImpl();
	@Test
	public void testsaveOrder() {
		
		Cart cart = new Cart();
		cart.addItem(new CartItem(1,"Excel从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
		cart.addItem(new CartItem(1,"VBA从入门到放弃",3,new BigDecimal(1000),new BigDecimal(100)));
		cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(10),new BigDecimal(100)));
		
	}
	
	@Test
	public void testShowMyOrders() {
		List<Order> orderList = orderDao.queryMyOrders(1);
		System.out.println(orderList);
		for(Order order:orderList) {
			System.out.println(order);
		}
	}
	
	@Test
	public void testShowAllOrders() {
		List<Order> allOrders = orderDao.queryAllOrders();
		for(Order order:allOrders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void testQueryOrderItems() {
		List<OrderItem> orderItems = orderDao.queryOrderItems("16496557773361");
		System.out.println(orderItems);
	}
	
	

}
