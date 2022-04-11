package com.atuigu.service;

import java.util.List;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

public interface BookService {
	
	//新增图书
	public void addBook(Book book);
	
	//更新图书
	public void updateBook(Book book);
	
	//删除图书
	public void deleteBookById(Integer id);
	
	//查询单本图书
	public Book queryBookById(Integer id);
	
	//查询图书列表
	public List<Book> queryBooks();

	public Page<Book> page(int pageNo, int pageSize);

	public Page<Book> pageByPrice(int begin, int pageSize, int min, int max);

}
