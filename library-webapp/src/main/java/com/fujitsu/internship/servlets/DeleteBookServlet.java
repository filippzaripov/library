package com.fujitsu.internship.servlets;

import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet class that processes requests for deletion book
 *
 * @author Filipp Zaripov
 */
public class DeleteBookServlet extends BaseServlet {

    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImplementation();
        Long id = Long.parseLong(req.getParameter("ID_to_delete"));
        HttpSession session = req.getSession(false);
        Book book = bookService.getBook(id);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        if (bookService.deleteBook(id)) {
            session.setAttribute("result", "Book '" + book.getName() + "' was removed successfully!");
        }
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
