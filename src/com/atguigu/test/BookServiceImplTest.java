package com.atguigu.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atuigu.service.BookService;
import com.atuigu.service.impl.BookServiceImpl;

public class BookServiceImplTest {
	
	private BookService bookService = new BookServiceImpl();

	@Test
	public void testAddBook() {
		bookService.addBook(new Book(null,"超人奶爸","国哥",new BigDecimal(28.4),29,98,null));
	}

	@Test
	public void testUpdateBook() {
		bookService.updateBook(new Book(13,"神经侠侣","金庸",new BigDecimal(22.4),29,98,null));
	}

	@Test
	public void testDeleteBookById() {
		bookService.deleteBookById(12);
	}

	@Test
	public void testQueryBookById() {
		Book book = bookService.queryBookById(12);
		System.out.println(book);
	}

	@Test
	public void testQueryBooks() {
		List<Book> list = bookService.queryBooks();
		System.out.println(list);
	}
	@Test
	public void testPage() {
		Page<Book> page = bookService.page(1, Page.PAGE_SIZE);
		System.out.println(page);
	}

}
