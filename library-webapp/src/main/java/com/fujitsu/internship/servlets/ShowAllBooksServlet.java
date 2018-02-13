package com.fujitsu.internship.servlets;

import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;
import com.fujitsu.internship.service.CategoryService;
import com.fujitsu.internship.service.CategoryServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet class that processes requests for show all books
 *
 * @author Filipp Zaripov
 */

public class ShowAllBooksServlet extends BaseServlet {

    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImplementation();
        CategoryService categoryService = new CategoryServiceImpl();
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        req.setAttribute("bookList", bookService.getAllBooks());
        req.setAttribute("categoriesList", categoryService.getAllBookCategories());
        //req.setAttribute("mainTableAlert", "display: none;");
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/main.jsp");
        requestDispatcher.forward(req, resp);
    }
}
