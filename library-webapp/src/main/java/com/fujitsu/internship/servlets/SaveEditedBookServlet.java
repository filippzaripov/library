package com.fujitsu.internship.servlets;

import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveEditedBookServlet extends BaseServlet {

    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImplementation();
        HttpSession session = req.getSession(false);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        if (session.getAttribute("saveType").equals("Create")) {
            String name = req.getParameter("name");
            Author author = new Author(req.getParameter("author"));
            BookCategory category = new BookCategory(req.getParameter("category"));
            Long id = bookService.createBook(new Book(name, category, author));
            if (id > 0) {
                session.setAttribute("displayEditBookAlert", "display: block;");
                session.setAttribute("displayErrorEditBookAlert", "display: none;");
                session.setAttribute("resultEdit", "Поздравляем! Книга: '" + name + "' была создана.");
            } else {
                session.setAttribute("displayErrorEditBookAlert", "display: block;");
                session.setAttribute("displayEditBookAlert", "display: none;");
                session.setAttribute("resultError", "Имя книги некорректно, пожалуйста введите корректные данные.");
            }
            resp.sendRedirect(req.getContextPath() + "/main/newBookForm");
        } else {
            Long editedBookId = Long.parseLong(req.getParameter("id"));
            boolean edited = bookService.editBook(editedBookId, req.getParameter("name"), new BookCategory(req.getParameter("category")), new Author(req.getParameter("author")));
            if (edited) {
                resp.sendRedirect(req.getContextPath() + "/main/books?page=1");
            } else {
                session.setAttribute("displayErrorEditBookAlert", "display: block;");
                session.setAttribute("displayEditBookAlert", "display: none;");
                session.setAttribute("resultError", "Имя книги некорректно, пожалуйста введите корректные данные.");
                resp.sendRedirect(req.getContextPath() + "/main/editBookForm");
            }

        }

    }
}
