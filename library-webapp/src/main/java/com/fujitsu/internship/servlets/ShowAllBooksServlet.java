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
        HttpSession session = req.getSession(false);
        int limit = 5;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        int pages = (int) Math.ceil((double) bookService.getAllBooks().size() / limit);
        if (req.getServletPath().matches("/main/books")) {
            int page = Integer.parseInt(req.getParameter("page"));
            if (page != pages && page != (pages-1)){
                req.setAttribute("beginPager", page);
            }else if(page == pages || page == pages - 1){
                req.setAttribute("beginPager", pages - 2);
            }
                req.setAttribute("bookList", bookService.getAllBooksPaging(limit, page));
        } else {
            req.setAttribute("beginPager", 1);
            req.setAttribute("bookList", bookService.getAllBooksPaging(limit, 1));
        }
        req.setAttribute("pages", pages);
        req.setAttribute("categoriesList", categoryService.getAllBookCategories());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/main.jsp");
        requestDispatcher.forward(req, resp);

    }
}
