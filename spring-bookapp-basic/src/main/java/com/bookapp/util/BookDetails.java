package com.bookapp.util;

import com.bookapp.model.Book;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class BookDetails {
    public List<Book> showBooks(){
        return Arrays.asList(
                new Book("Java in action","John David","Tech",01,5000),
                new Book("5am club","Robbin Sharma","Selfhelp",02,3000),
                new Book("HTML for Dummies","Ben John","Tech",03,4500),
                new Book("Secret Seven","Enid Ben","Fiction",04,3500),
                new Book("Seven Habits","John Hopper","Selfhelp",04,3550));
    }
}
