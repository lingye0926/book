package com.atguigu.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

public class BookDaoImplTest {
	BookDao bookDao = new BookDaoImpl();
	

	@Test
	public void testAddBook() {
		bookDao.addBook(new Book(null,"神雕侠侣","金庸",new BigDecimal(22.4),29,98,null));
		
	}

	@Test
	public void testDeleteBookById() {
		bookDao.deleteBookById(11);
	}

	@Test
	public void testUpdateBook() {
		bookDao.updateBook(new Book(8,"做时间的朋友","罗正宇",new BigDecimal(22),290,98,null));
	}

	@Test
	public void testQueryBookById() {
		Book book = bookDao.queryBookById(8);
		System.out.println(book);
	}

	@Test
	public void testQueryBooks() {
		List<Book> books = bookDao.queryBooks();
		System.out.println(books);
	}
	
	@Test
	public void testQueryForPageTotalCount() {
		int totalCount = bookDao.queryForPageTotalCount();
		System.out.println(totalCount);
	}

	@Test
	public void testQueryForPageItems() {
		List<Book> items = bookDao.queryForPageItems(0, Page.PAGE_SIZE);
		System.out.println(items);
	}

}
