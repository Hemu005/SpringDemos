package com.bookapp.util;

public class Queries {

    public static final String InsertQuery="INSERT INTO book(bookId,title,author,category,price)VALUES(?,?,?,?,?);";
    public static final String UpdateQuery="UPDATE book set price=? WHERE bookId=?;";
    public static final String DeleteQuery="DELETE from book WHERE bookId=?;";

    public static final String SelectQuery="SELECT * FROM BOOK";
    public static final String SelectByAuthorQuery="SELECT * FROM BOOK WHERE author=?";
    public static final String SelectByCategoryQuery="SELECT * FROM BOOK WHERE category=?";
    public static final String SelectByPriceQuery="SELECT * FROM BOOK WHERE price<?";
    public static final String SelectByAuthorContainsAndCategoryQuery="SELECT * FROM BOOK WHERE author=? && category=?";
    public static final String SelectByIdQuery="SELECT * FROM BOOK WHERE bookId=?";
}
