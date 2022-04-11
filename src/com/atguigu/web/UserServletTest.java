package com.atguigu.web;


import java.lang.reflect.Method;

public class UserServletTest {
	
	public void login() {

		System.out.println("这是login()方法调用了");
	}
	
	public void regist() {
		System.out.println("这是regist()方法调用了");
	}
	
	public void updateUser() {
		System.out.println("这是updateUser()方法调用了");
	}
	
	public static void main(String[] args) {
		Method[] methods = UserServletTest.class.getDeclaredMethods();
		for(Method m:methods) {
			try {
				m.invoke(new UserServletTest());
			} catch (Exception e) {
	
				e.printStackTrace();
			}
		}
	}
}
