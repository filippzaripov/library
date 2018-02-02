package com.fujitsu.internship.servlets;

import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;
import com.fujitsu.internship.service.CategoryService;
import com.fujitsu.internship.service.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet class that processes requests for finding book
 *
 * @author Filipp Zaripov
 */

public class ShowAllBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImplementation();
        CategoryService categoryService = new CategoryServiceImpl();
        req.setAttribute("bookList", bookService.getAllBooks());
        req.setAttribute("categoriesList", categoryService.getAllBookCategories());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/main.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
