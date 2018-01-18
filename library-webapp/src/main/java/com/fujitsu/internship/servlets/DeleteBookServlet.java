package com.fujitsu.internship.servlets;

import com.fujitsu.internship.dao.BookDAO;
import com.fujitsu.internship.dao.Validator;
import com.fujitsu.internship.dao.pg.PostgreSQLBookDAO;
import com.fujitsu.internship.model.Book;
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
        Validator validator = new Validator();
        BookDAO bookDAO = new PostgreSQLBookDAO();
        String idFromField = req.getParameter("ID_to_delete");
        if (StringUtils.isNumeric(idFromField)) {
            Long id = Long.parseLong(idFromField);
            Book book  = bookDAO.getBook(id);
            Long idOfDeletedBook = bookDAO.delete(id);
            if (idOfDeletedBook != null) {
                req.setAttribute("result", "Book Name: '" + book.getName() + "' with ID: '" + book.getId() + "' was removed from database");
            } else {
                req.setAttribute("result", "This ID is not correct.\nPlease enter correct one.");
            }
        }else {
            req.setAttribute("result", "This ID is not correct.\nPlease enter correct one.");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
