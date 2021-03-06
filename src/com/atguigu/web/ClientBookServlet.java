package com.atguigu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.utils.WebUtils;
import com.atuigu.service.BookService;
import com.atuigu.service.impl.BookServiceImpl;

public class ClientBookServlet extends BaseServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();
	
	protected void page(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1 获取请求的参数;pageNo 和 pageSize
		int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
		int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
		//2 调用BookService.page(pageNo,pageSize)：Page对象
		Page<Book> page = bookService.page(pageNo,pageSize);
		page.setUrl("client/bookServlet?action=page");
		//3 保存Page对象到request域中
		req.setAttribute("page", page);
		//4 请求转发到pages/manager/book_manager.jsp页面
		req.getRequestDispatcher("/pages/client/index.jsp").forward(req, res);
	}
	
	protected void pageByPrice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
		int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
		int min = WebUtils.parseInt(req.getParameter("min"), 0);
		int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
		
		Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
		StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
		//如果有最小价格的参数，追加到分页条的地址参数中
		if(req.getParameter("min") != null) {
			sb.append("&min=").append(req.getParameter("min"));
		}
		//如果有最大价格的参数，追加到分页条的地址参数中
		if(req.getParameter("max") != null) {
			sb.append("&max=").append(req.getParameter("max"));
		}
		page.setUrl(sb.toString());
		req.setAttribute("page", page);
		req.getRequestDispatcher("/pages/client/index.jsp").forward(req, res);
	
	}

}
