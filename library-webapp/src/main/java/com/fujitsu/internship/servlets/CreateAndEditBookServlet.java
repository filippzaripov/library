package com.fujitsu.internship.servlets;

import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;
import com.fujitsu.internship.service.CategoryService;
import com.fujitsu.internship.service.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateAndEditBookServlet extends BaseServlet {
    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        BookService bookService = new BookServiceImplementation();
        CategoryService categoryService = new CategoryServiceImpl();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        session.setAttribute("categoriesList", categoryService.getAllBookCategories());
        session.setAttribute("result", null);
        session.setAttribute("displayEditBookAlert", "display: none;");
        session.setAttribute("displayErrorEditBookAlert", "display: none;");

        if (req.getServletPath().equals("/main/createBook")) {
            session.setAttribute("displayId", "display: none;");
            session.setAttribute("title", "Create Book");
            session.setAttribute("saveType", "Create");
            session.setAttribute("name", "");
            session.setAttribute("author", "");
            resp.sendRedirect(req.getContextPath() + "/main/newBookForm");
        } else {
            session.setAttribute("displayId", "display: block;");
            session.setAttribute("title", "Edit Book");
            Long idFromField = Long.parseLong(req.getParameter("editBookId"));
            Book oldBook = bookService.getBook(idFromField);
            session.setAttribute("id", idFromField);
            session.setAttribute("name", oldBook.getName());
            session.setAttribute("author", oldBook.getAuthor().getName());
            session.setAttribute("saveType", "Save");
            resp.sendRedirect(req.getContextPath() + "/main/editBookForm");
        }
    }

}
