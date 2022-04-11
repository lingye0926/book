package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

public class OrderDaoImpl extends BaseDao implements OrderDao{

	@Override
	public int saveOrder(Order order) {
		String sql = "insert into t_order (`order_id`,`create_time`,`price`,`status`,`user_id`) values (?,?,?,?,?)";
		int save = update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
		return save;
	}

	@Override
	public List<Order> queryMyOrders(Integer userId) {
		String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where `user_id` = ?";
		List<Order> orderList = queryList(Order.class, sql,userId);
		return orderList;
	}

	@Override
	public List<Order> queryAllOrders() {
		String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order";
		return queryList(Order.class, sql);
	}

	@Override
	public List<OrderItem> queryOrderItems(String orderId) {
		String sql = "select `id`,`name`,`count`,`price`,`total_price` totalPrice,`order_id` orderId from t_order_item where `order_id`= ?";
		return queryList(OrderItem.class, sql,orderId);
	}

	@Override
	public void updateOrderStatustoSend(String orderId) {
		String sql = "update t_order set `status` = 1 where `order_id`= ?";
		 update(sql, orderId);
	}

	@Override
	public void updateOrderStatustoRecieve(String orderId) {
		String sql = "update t_order set `status` = 2 where `order_id`= ?";
		 update(sql, orderId);
		
	}

}
