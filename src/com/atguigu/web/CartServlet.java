package com.atguigu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.utils.WebUtils;
import com.atuigu.service.BookService;
import com.atuigu.service.impl.BookServiceImpl;

public class CartServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookServiceImpl();

	protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = WebUtils.parseInt(req.getParameter("id"), 0);
		Book book = bookService.queryBookById(id);
		CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		cart.addItem(cartItem);
//		System.out.println(cart);
		req.getSession().setAttribute("lastBookName", cartItem.getName());
		resp.sendRedirect(req.getHeader("Referer"));
	}
	
	protected void deletItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = WebUtils.parseInt(req.getParameter("id"), 0);
		Cart cart = (Cart)req.getSession().getAttribute("cart");
		if(cart != null) {
		cart.deleteItem(id);
		resp.sendRedirect(req.getHeader("Referer"));
		}
	}
	
	protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart = (Cart)req.getSession().getAttribute("cart");
		if(cart != null) {
			cart.clear();
			resp.sendRedirect(req.getHeader("Referer"));
		}
		
	}
	
	protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = WebUtils.parseInt(req.getParameter("count"), 0);
		int id = WebUtils.parseInt(req.getParameter("id"), 1);
		Cart cart = (Cart)req.getSession().getAttribute("cart");
		if(cart != null) {
			cart.updateCount(id, count);
			resp.sendRedirect(req.getHeader("Referer"));
		}
	}
	

}
