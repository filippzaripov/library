package servlets;

import dao.BookDAO;
import dao.Validator;
import dao.pg.PostgreSQLBookDAO;
import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet class that processes requests for finding book in database
 * @author Filipp Zaripov
 */
public class FindBookByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> bookList = new ArrayList();
        String idFromField = req.getParameter("id");
        BookDAO bookDAO = new PostgreSQLBookDAO();
        Validator validator = new Validator();
        if (validator.isIDCorrect(idFromField)) {
            Long id = Long.parseLong(idFromField);
            bookList.add(bookDAO.getBook(id));
            req.setAttribute("bookList", bookList);
        }else{
            req.setAttribute("result", "This ID is not correct.\nPlease enter correct one.");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
