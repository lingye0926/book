package com.atguigu.dao.impl;

import java.util.List;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;


public class BookDaoImpl extends BaseDao implements BookDao{

	@Override
	public int addBook(Book book) {
		
		String sql = "insert into t_book (`name`,`price`,`author`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
		return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath());
		
	}

	@Override
	public int deleteBookById(Integer id) {
		String sql = "delete from t_book where id= ?";
		return update(sql, id);
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update t_book set name=?,author=?,price =?,sales =?,stock =?,img_path=? where id = ?";
		return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
		
	}

	@Override
	public Book queryBookById(Integer id) {
		String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` from t_book where id = ?";
		return queryforone(Book.class, sql, id);
	}

	@Override
	public List<Book> queryBooks() {
		String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book";
		return queryList(Book.class, sql);
	}

	@Override
	public int queryForPageTotalCount() {
		String sql = "select count(*) from t_book";
		Number count = (Number)queryForSinglevalue(sql);
		return count.intValue();
	}

	@Override
	public List<Book> queryForPageItems(int begin, int pageSize) {
		String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";
		return queryList(Book.class, sql, begin, pageSize);
	}

	@Override
	public Integer queryForPageTotalCountByPrice(int min, int max) {
		String sql = "select count(*) from t_book where `price` between ? and ?";
		Number count = (Number)queryForSinglevalue(sql,min, max);
		return count.intValue();
	}

	@Override
	public List<Book> queryPageItemsByPrice(int begin, int pageSize, int min, int max) {
		String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book where `price` between ? and ? order by `price` limit ?,?";
		List<Book> list = queryList(Book.class, sql, min,max,begin,pageSize);
		return list;
	}

}
