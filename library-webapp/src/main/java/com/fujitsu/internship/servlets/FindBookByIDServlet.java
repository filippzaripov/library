package com.fujitsu.internship.servlets;

import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;
import com.fujitsu.internship.service.CategoryService;
import com.fujitsu.internship.service.CategoryServiceImpl;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet class that processes requests for finding book in database
 *
 * @author Filipp Zaripov
 */
public class FindBookByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> bookList = new ArrayList();
        CategoryService categoryService = new CategoryServiceImpl();
        String idFromField = req.getParameter("id");
        BookService bookService = new BookServiceImplementation();
        req.setAttribute("categoriesList", categoryService.getAllBookCategories());
        RequestDispatcher requestDispatcher;
        if (StringUtils.isNumeric(idFromField)) {
            Long id = Long.parseLong(idFromField);
            Book book = bookService.getBook(id);
            if (book != null) {
                bookList.add(book);
                req.setAttribute("bookList", bookList);
                requestDispatcher = req.getRequestDispatcher("jsp/main.jsp");
            } else {
                req.setAttribute("result", "Book with this ID wasn't found.\nPlease enter correct ID.");
                requestDispatcher = req.getRequestDispatcher("/main");
            }
        } else {
            req.setAttribute("result", "This ID is not correct.\nPlease enter correct one.");
            requestDispatcher = req.getRequestDispatcher("/main");
        }

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
