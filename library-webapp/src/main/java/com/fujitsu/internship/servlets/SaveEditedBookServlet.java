package com.fujitsu.internship.servlets;

import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.BookCategory;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveEditedBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImplementation();
        Long editedBookId = Long.parseLong(req.getParameter("id"));
        bookService.editBook(editedBookId, req.getParameter("name"), new BookCategory(req.getParameter("category")), new Author(req.getParameter("author")));
        req.getRequestDispatcher("main").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
