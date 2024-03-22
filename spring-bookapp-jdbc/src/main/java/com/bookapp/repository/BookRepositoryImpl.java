package com.bookapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.Queries;
@Repository //connect to jdbc
public class BookRepositoryImpl implements IBookRepository{
	
    @Autowired
    private JdbcTemplate jdbcTemplate;//responsible for db operations
    
    public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
    	super();
    	this.jdbcTemplate=jdbcTemplate;
    }
    
	@Override
	public List<Book> findAll() {
		RowMapper<Book> mapper=new BookMapper();
		List<Book> books=jdbcTemplate.query(Queries.SelectQuery, mapper);
		return books;
	}

	@Override
	public List<Book> findByAuthorStartsWith(String author) throws BookNotFoundException {
		return jdbcTemplate.query(Queries.SelectByAuthorQuery, (rs,rowNum)->{
			Book book=new Book();
			  book.setAuthor(rs.getString("author"));
			  book.setBookId(rs.getInt("bookId"));
			  book.setTitle(rs.getString("title"));
			  book.setCategory(rs.getString("category"));
			  book.setPrice(rs.getDouble("price"));
				return book;	
		}, author);
	}

	@Override
	public List<Book> findByCategory(String category) throws BookNotFoundException {
	    RowMapper<Book> mapper=new BookMapper();
	    List<Book> booksByCategory=jdbcTemplate.query(Queries.SelectByCategoryQuery, mapper, category);
		return booksByCategory;
	}

	@Override
	public List<Book> findByPriceLessThan(double price) throws BookNotFoundException {
		  RowMapper<Book> mapper=new BookMapper();
		    List<Book> booksByPrice=jdbcTemplate.query(Queries.SelectByCategoryQuery, mapper, price);
			return booksByPrice;
	}

	@Override
	public List<Book> findByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		 RowMapper<Book> mapper=new BookMapper();
		    List<Book> booksByAuthorAndCategory=jdbcTemplate.query(Queries.SelectByAuthorContainsAndCategoryQuery, mapper, author,category);
			return booksByAuthorAndCategory;
	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
		
		Book book=jdbcTemplate.queryForObject(Queries.SelectByIdQuery, new BookMapper(), bookId);
		return book;
	}

	@Override
	public void addBook(Book book) {
		Object[] bookArr= {book.getBookId(),book.getTitle(),book.getAuthor(),book.getCategory(),book.getPrice()};
		jdbcTemplate.update(Queries.InsertQuery, bookArr);
	}

	@Override
	public void updateBook(int bookId, double price) {
		jdbcTemplate.update(Queries.UpdateQuery, bookId,price);		
	}

	@Override
	public void deleteBook(int bookId) {
	  jdbcTemplate.update(Queries.DeleteQuery, bookId);
	}
}
