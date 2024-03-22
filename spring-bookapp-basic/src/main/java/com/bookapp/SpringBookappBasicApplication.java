package com.bookapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappBasicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappBasicApplication.class, args);
	}
    @Autowired
    IBookService bookService;
    
	@Override
	public void run(String... args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
        System.out.println("1.List of books" +
                           " 2.Author" +
                           " 3.Category" +
                           " 4.Price less than" +
                           " 5.Author and Category" +
                           " 6.BookId");
        System.out.println("Enter your choice : ");
        int choice =sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Available Books");
                List<Book> books=bookService.getAll();
                for (Book book:books){
                    System.out.println(book);
                }
                break;
            case 2:
                System.out.println("Author name start with:");
                String auth=sc.next();
                try {
                    List<Book> bookByStartsWith=bookService.getByAuthorStartsWith(auth);
                    for (Book book:bookByStartsWith){
                        System.out.println(book);
                    }
                } catch (BookNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.println("Enter the category name: ");
                String cat=sc.next();
                try {
                    List<Book> bookByCategory = bookService.getByCategory(cat);
                    for (Book book : bookByCategory) {
                        System.out.println(book);
                    }
                }catch (BookNotFoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.println("Enter the price:");
                double price=sc.nextDouble();
                try {
                    List<Book> bookByPrice=bookService.getByPriceLessThan(price);
                    for (Book book:bookByPrice){
                        System.out.println(book);
                    }
                }catch (BookNotFoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                System.out.println("Enter the author and category :");
                String aut=sc.next();
                String cate=sc.next();
                try {
                    List<Book> bookAuthorAndCategory=bookService.getByAuthorContainsAndCategory(aut,cate);
                    for (Book book:bookAuthorAndCategory){
                        System.out.println(book);
                    }
                }catch (BookNotFoundException e){
                    System.out.println(e.getMessage());
                }
            case 6:
                System.out.println("Enter the Id :");
                int bookid=sc.nextInt();
                Book bookById=null;
                try {
//                    bookById= (Book) bookService.getById(bookid);
//                    for (Book book:bookById){
//                        System.out.println(book);
//                    }
                    System.out.println( bookService.getById(bookid));
//                bookService.getById(bookid);
                }catch (IdNotFoundException e){
                    System.out.println(e.getMessage());
                }
        }	
	}

}
