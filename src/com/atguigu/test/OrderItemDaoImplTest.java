package com.atguigu.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;

public class OrderItemDaoImplTest {
	OrderItemDao orderItemDao = new OrderItemDaoImpl();

	@Test
	public void testSaveOrderItem() {
		orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到放弃",0,new BigDecimal(100),new BigDecimal(100),"1234567890"));
		orderItemDao.saveOrderItem(new OrderItem(null,"javascript从入门到放弃",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
		orderItemDao.saveOrderItem(new OrderItem(null,"C#从入门到放弃",2 ,new BigDecimal(100),new BigDecimal(100),"1234567890"));
		orderItemDao.saveOrderItem(new OrderItem(null,"C从入门到放弃",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
	}

}
