package com.bookapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJdbcApplication implements CommandLineRunner{
    @Autowired
    IBookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Add book \n"
				+ "2.Update book \n"+
				"3.Delete book \n"+
				"4.Get All books \n"+
				"5.Get book by entering Author Name \n"+
				"6.Get book by entering category \n"+
				"7.Get book by entering price less than \n"+
				"8.Get book by entering author and category \n"+
				"9.Get book by entering bookId");
		System.out.println("Enter your choice:");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter bookId:");
			int id=sc.nextInt();
			System.out.println("Enter title:");
			String title=sc.next();
			System.out.println("Enter author:");
			String auth=sc.next();
			System.out.println("Enter category");
			String cat=sc.next();
			System.out.println("Enter price:");
			double price=sc.nextDouble();
			bookService.addBook(new Book(id,title,auth,cat,price));
			break;
		case 2:
			System.out.println("Enter bookId:");
			int id1=sc.nextInt();
			System.out.println("Enter price:");
			double price1=sc.nextDouble();
			bookService.updateBook(id1, price1);
			break;
		case 3:
			System.out.println("Enter bookId:");
			int id2=sc.nextInt();
			bookService.deleteBook(id2);
			break;
		case 4:
			 System.out.println("Books List:");
		       List<Book> bookList=bookService.findAll();
		        for (Book book : bookList) {
				   System.out.println(book);
			    }
		     break;
		case 5:
			System.out.println("Enter the Author name:");
			String name=sc.next();
			List<Book> bookList1=bookService.findByAuthorStartsWith(name);
			for (Book book : bookList1) {
				System.out.println(book);
			}
			break;
		case 6:
			System.out.println("Enter category:");
			String cat1=sc.next();
			List<Book> bookList2=bookService.findByCategory(cat1);
			for (Book book : bookList2) {
				System.out.println(book);
			}
			break;
		case 7:
			System.out.println("Enter price less than:");
			double price2=sc.nextDouble();
			List<Book> booList3=bookService.findByPriceLessThan(price2);
			for (Book book : booList3) {
				System.out.println(book);
			}
			break;
		case 8:
			System.out.println("Enter author and category");
			String auth2=sc.next();
			String cat2=sc.next();
			List<Book> booList4=bookService.findByAuthorContainsAndCategory(auth2, cat2);
			for (Book book : booList4) {
				System.out.println(book);
			}
			break;
		case 9:
			System.out.println("Enter bookId");
			int id3=sc.nextInt();
		    Book book=bookService.findById(id3);
		    System.out.println(book);
		}
		   
		
	}

}
