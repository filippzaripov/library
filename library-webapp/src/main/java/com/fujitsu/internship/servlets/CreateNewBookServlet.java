package com.fujitsu.internship.servlets;

import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet class that processes requests for creating new book
 *
 * @author Filipp Zaripov
 */
public class CreateNewBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImplementation();
        String name = req.getParameter("name");
        Author author = new Author(req.getParameter("author"));
        BookCategory category = new BookCategory(req.getParameter("categoryName"));
        Book book = bookService.createBook(new Book(name, category, author));
        if (book != null) {
            req.setAttribute("result", "Book '" + name + "' was added to database");
        } else {
            req.setAttribute("result", "Book name or category is not correct");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
