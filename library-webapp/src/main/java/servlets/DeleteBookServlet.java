package servlets;

import dao.BookDAO;
import dao.Validator;
import dao.pg.PostgreSQLBookDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet class that processes requests for deletion book
 * @author Filipp Zaripov
 */
public class DeleteBookServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Validator validator = new Validator();
        BookDAO bookDAO = new PostgreSQLBookDAO();
        String idFromField = req.getParameter("ID_to_delete");
            if (validator.isIDCorrect(idFromField)) {
                Long id = Long.parseLong(idFromField);
                try {
                    String name = bookDAO.getBook(id).getName();
                    bookDAO.delete(id);
                    req.setAttribute("result", "Book " + name + " was removed from database");
                } catch (Exception e) {
                    System.err.println("class : DeleteBookServlet , line : 24");
                }
            } else {
                req.setAttribute("result", "This ID is not correct.\nPlease enter correct one.");
            }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
