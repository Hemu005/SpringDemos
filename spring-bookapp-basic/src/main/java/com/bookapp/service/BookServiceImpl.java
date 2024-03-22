package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements IBookService{
	
	private BookDetails details;
	
	@Autowired
    public void setDetails(BookDetails details) {
		this.details = details;
	}
    @Override
    public List<Book> getAll() {
        List<Book> books= details.showBooks();
        return books;
    }

	@Override
    public List<Book> getByAuthorStartsWith(String author) throws BookNotFoundException {
        List<Book> books=details.showBooks();
        List<Book> bookByStartsWith=new ArrayList<>();
        for (Book book:books){
          if(book.getAuthor().toLowerCase().contains(author)){
              bookByStartsWith.add(book);
          }
        }
        if(bookByStartsWith.isEmpty()){
            throw new BookNotFoundException("Book doesn't match with "+author+" author");
        }
        return bookByStartsWith;
    }

    @Override
    public List<Book> getByCategory(String category) throws BookNotFoundException {
        List<Book> books=details.showBooks();
        List<Book> bookByCategory=new ArrayList<>();
        for (Book book:books){
            if (book.getCategory().toLowerCase().equals(category)){
                bookByCategory.add(book);
            }
        }
        if(bookByCategory.isEmpty()){
            throw new BookNotFoundException("Book doesn't match with "+category+" category");
        }
        return bookByCategory;
    }

    @Override
    public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
        List<Book> books=details.showBooks();
        List<Book> bookByPrice=new ArrayList<>();
        for (Book book:books){
            if (book.getPrice()<(price)){
                bookByPrice.add(book);
            }
        }
        if(bookByPrice.isEmpty()){
            throw new BookNotFoundException("Book doesn't match with "+price+" price");
        }
        return bookByPrice;
    }

    @Override
    public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
        List<Book> books=details.showBooks();
        List<Book> bookAuthorAndCategory=new ArrayList<>();
        for (Book book:books){
            if (book.getAuthor().toLowerCase().equals(author) && book.getCategory().toLowerCase().equals(category)){
                bookAuthorAndCategory.add(book);
            }
        }
        if(bookAuthorAndCategory.isEmpty()){
            throw new BookNotFoundException("Book doesn't match with "+author+" author and "+category+" category");
        }
        return bookAuthorAndCategory;
    }

    @Override
    public Book getById(int bookId) throws IdNotFoundException {
        List<Book> books=details.showBooks();
        for (Book book:books){
            if (book.getBookId()==bookId){
                return book;
            }
        }

        throw new IdNotFoundException("Book doesn't match with "+bookId);
    }
}
