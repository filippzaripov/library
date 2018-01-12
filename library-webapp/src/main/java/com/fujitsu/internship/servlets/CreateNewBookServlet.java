package com.fujitsu.internship.servlets;

import com.fujitsu.internship.dao.BookDAO;
import com.fujitsu.internship.dao.Validator;
import com.fujitsu.internship.dao.pg.PostgreSQLBookDAO;
import com.fujitsu.internship.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet class that processes requests for creating new book
 * @author Filipp Zaripov
 */
public class CreateNewBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new PostgreSQLBookDAO();
        String name= req.getParameter("name");
        String category = req.getParameter("category_name");
        Validator validator = new Validator();
        if (validator.validateNewBookField(name, category)){
            bookDAO.addBook(new Book(name,category));
            req.setAttribute("result", "Book "+ name +" was added to database");
        }else {
            req.setAttribute("result", "Book name or category is not correct");
        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
