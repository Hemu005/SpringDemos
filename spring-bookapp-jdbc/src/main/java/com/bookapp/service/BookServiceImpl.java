package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;
@Service
public class BookServiceImpl implements IBookService{
	
@Autowired
IBookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		List<Book> books=bookRepository.findAll();
		return books;
	}

	@Override
	public List<Book> findByAuthorStartsWith(String author) throws BookNotFoundException {
		List<Book>  books=bookRepository.findByAuthorStartsWith(author);
		if (books.isEmpty()) {
			throw new BookNotFoundException("Doesn't written any books by this author :"+author);
		}
		return books;
	}

	@Override
	public List<Book> findByCategory(String category) throws BookNotFoundException {
	    List<Book> books=bookRepository.findByCategory(category);
	    if (books.isEmpty()) {
			throw new BookNotFoundException("Doesn't have book by this category:"+category);
		}
		return books;
	}

	@Override
	public List<Book> findByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books=bookRepository.findByPriceLessThan(price);
		if (books.isEmpty()) {
			throw new BookNotFoundException("Doesn't have any book by this price");
		}
		return books;
	}

	@Override
	public List<Book> findByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> books=bookRepository.findByAuthorContainsAndCategory(author, category);
		if (books.isEmpty()) {
			throw new BookNotFoundException("Doesn't have any books with this author and category");
		}
		return books;
	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
	    if (bookRepository.findById(bookId)==null) {
			throw new IdNotFoundException("Doesn't have any books by this id: "+bookId);
		}
		return bookRepository.findById(bookId);
	}

	@Override
	public void addBook(Book book) {
		bookRepository.addBook(book);
		
	}

	@Override
	public void updateBook(int bookId, double price) {
		bookRepository.updateBook(bookId, price);
		
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteBook(bookId);
		
	}
  
}
