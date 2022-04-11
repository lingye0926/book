package com.atuigu.service;

import java.util.List;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

public interface OrderService {
	//创建/保存订单
	public String createOrder(Cart cart, Integer userId);
	//查看我的全部订单
	public List<Order> showMyOrders(Integer userId);
	//发货
	public void sendOrder(String orderId);
	//获取订单详情
	List<OrderItem> showOrderDetails(String orderId);
	//管理员查看全部订单
	public List<Order> showAllOrders();
	//签收
	public void recieveOrder(String orderId);
	
}
