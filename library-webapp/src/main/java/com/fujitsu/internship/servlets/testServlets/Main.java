package com.fujitsu.internship.servlets.testServlets;

import com.fujitsu.internship.dao.BookDAO;
import com.fujitsu.internship.dao.pg.PostgreSQLBookDAO;
import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.BookCategory;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImplementation();
        BookDAO bookDAO = new PostgreSQLBookDAO();
        //bookService.editBook(206, "name", new BookCategory("kids"), new Author("Filipp Zaripov"));
        bookDAO.editBook(206, "name", new BookCategory("kids"), new Author("Filipp Zaripov"));
    }
}
