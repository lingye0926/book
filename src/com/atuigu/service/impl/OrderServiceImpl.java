package com.atuigu.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atuigu.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	OrderDao orderDao = new OrderDaoImpl();
	BookDao bookDao = new BookDaoImpl();
	OrderItemDao orderItemDao = new OrderItemDaoImpl();

	@Override
	public String createOrder(Cart cart, Integer userId) {
		//订单号---唯一性
		String orderId = System.currentTimeMillis() + "" + userId;
		//创建一个订单对象
		Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
		//保存订单
		orderDao.saveOrder(order);
		//遍历购物车中每一项转化成为订单项保存到数据库
		for(Map.Entry<Integer,CartItem> entry:cart.getItems().entrySet()) {
			//获取每一个购物车中的商品项
			CartItem cartItem = entry.getValue();
			//转换为每一个订单项
			OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
			//保存订单项到数据库
			orderItemDao.saveOrderItem(orderItem);
			
			//更新图书库存和销量
			Book book = bookDao.queryBookById(cartItem.getId());
			book.setStock(book.getStock() - cartItem.getCount());
			book.setSales(book.getSales() + cartItem.getCount());
			bookDao.updateBook(book);
		}
		//清空购物车数据
		cart.clear();
		return orderId;
	}

	@Override
	public List<Order> showMyOrders(Integer userId) {
		 return orderDao.queryMyOrders(userId);
	}

	@Override
	public void sendOrder(String orderId) {
		orderDao.updateOrderStatustoSend(orderId);
		
	}

	@Override
	public List<OrderItem> showOrderDetails(String orderId) {
		return orderDao.queryOrderItems(orderId);
		
	}

	@Override
	public List<Order> showAllOrders() {
		return orderDao.queryAllOrders();
		
	}

	@Override
	public void recieveOrder(String orderId) {
		orderDao.updateOrderStatustoRecieve(orderId);
		
	}
}
