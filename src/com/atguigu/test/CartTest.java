package com.atguigu.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;

public class CartTest {
	Cart cart = new Cart();

	@Test
	public void testAddItem() {
		cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
		cart.addItem(new CartItem(1,"Java从入门到放弃",3,new BigDecimal(1000),new BigDecimal(100)));
		cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(10),new BigDecimal(100)));
		System.out.println(cart);
	}

	@Test
	public void testDeleteItem() {
		cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
		cart.addItem(new CartItem(1,"Java从入门到放弃",3,new BigDecimal(1000),new BigDecimal(100)));
		cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(10),new BigDecimal(100)));
		cart.deleteItem(1);
		System.out.println(cart);
	}

	@Test
	public void testClear() {
		cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
		cart.addItem(new CartItem(1,"Java从入门到放弃",3,new BigDecimal(1000),new BigDecimal(100)));
		cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(10),new BigDecimal(100)));
		cart.clear();
		System.out.println(cart);
	}

	@Test
	public void testUpdateCount() {
		cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
		cart.addItem(new CartItem(1,"Java从入门到放弃",3,new BigDecimal(1000),new BigDecimal(100)));
		cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(10),new BigDecimal(100)));
		cart.updateCount(1, 10);
		System.out.println(cart);
	}

}
