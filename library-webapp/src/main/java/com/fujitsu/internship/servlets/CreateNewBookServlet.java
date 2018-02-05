package com.fujitsu.internship.servlets;

import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;
import com.fujitsu.internship.service.CategoryService;
import com.fujitsu.internship.service.CategoryServiceImpl;

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
        CategoryService categoryService = new CategoryServiceImpl();
        if (req.getServletPath().equals("/createBook")) {
            req.setAttribute("categoriesList", categoryService.getAllBookCategories());
        } else {
            String name = req.getParameter("name");
            Author author = new Author(req.getParameter("author"));
            BookCategory category = new BookCategory(req.getParameter("category"));
            Book book = bookService.createBook(new Book(name, category, author));
            req.setAttribute("result", "Congratulations! Book: '" + book.getName() +"' was created");
            req.getRequestDispatcher("/createBook").forward(req,resp);
        }
        req.getRequestDispatcher("/jsp/createBookForm.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
