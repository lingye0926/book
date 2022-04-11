package com.atguigu.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.utils.WebUtils;
import com.atuigu.service.BookService;
import com.atuigu.service.impl.BookServiceImpl;

public class BookServlet extends BaseServlet{
	private BookService bookService = new BookServiceImpl();

	private static final long serialVersionUID = 1L;
	
	protected void add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
		pageNo += 1;
		Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
		bookService.addBook(book);
		res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
		Integer id = Integer.parseInt(req.getParameter("id"));
		 bookService.deleteBookById(id);
		 res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
	}
	
	protected void getBook(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
		Book book = bookService.queryBookById(id);
		req.setAttribute("book", book);
		req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, res);
	}
	
	protected void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
		Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
		bookService.updateBook(book);
		res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Book> books = bookService.queryBooks();
//		System.out.println(books);
		req.setAttribute("books", books);
		req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, res);
		
	}
	protected void page(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1 获取请求的参数;pageNo 和 pageSize
		int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
		int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
		//2 调用BookService.page(pageNo,pageSize)：Page对象
		Page<Book> page = bookService.page(pageNo,pageSize);
		page.setUrl("manager/bookServlet?action=page");
		//3 保存Page对象到request域中
		req.setAttribute("page", page);
		//4 请求转发到pages/manager/book_manager.jsp页面
		req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, res);
	}

}
