package com.atguigu.dao;

import java.util.List;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

public interface OrderDao {
	
	public int saveOrder(Order order);

	public List<Order> queryMyOrders(Integer userId);
	
	public List<Order> queryAllOrders();
	
	public List<OrderItem> queryOrderItems(String orderId);
	
	public void updateOrderStatustoSend(String orderId);
	
	public void updateOrderStatustoRecieve(String orderId);

}
