package servlets;

import dao.BookDAO;
import dao.Validator;
import dao.pg.PostgreSQLBookDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet class that processes requests for finding book in database
 * @author Filipp Zaripov
 */
public class FindBookByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idFromField = req.getParameter("ID");
        BookDAO bookDAO = new PostgreSQLBookDAO();
        Validator validator = new Validator();
        if (validator.isIDCorrect(idFromField)) {
            Long id = Long.parseLong(idFromField);
            req.setAttribute("result", bookDAO.getBook(id));
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
