package com.atguigu.dao;

import java.util.List;

import com.atguigu.pojo.Book;

public interface BookDao {
	
	public int addBook(Book book);
	
	public int deleteBookById(Integer id);
	
	public int updateBook(Book book);
	
	public Book queryBookById(Integer id);
	
	public List<Book> queryBooks();

	public int queryForPageTotalCount();

	public List<Book> queryForPageItems(int begin, int pageSize);

	public Integer queryForPageTotalCountByPrice(int min, int max);

	public List<Book> queryPageItemsByPrice(int begin, int pageSize, int min, int max);
	

}
