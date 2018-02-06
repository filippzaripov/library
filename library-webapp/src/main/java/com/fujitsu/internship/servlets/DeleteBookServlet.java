package com.fujitsu.internship.servlets;

import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet class that processes requests for deletion book
 *
 * @author Filipp Zaripov
 */
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImplementation();
        String idFromField = req.getParameter("ID_to_delete");
        if (StringUtils.isNumeric(idFromField)) {
            Long id = Long.parseLong(idFromField);
            Book book = bookService.getBook(id);
            if (bookService.deleteBook(id)) {
                req.setAttribute("result", "Book Name: '" + book.getName() + "' with ID: '" + book.getId() + "' was removed from database");
            } else {
                req.setAttribute("result", "This ID is not correct.\nPlease enter correct one.");
            }
        } else {
            req.setAttribute("result", "This ID is not correct.\nPlease enter correct one.");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
