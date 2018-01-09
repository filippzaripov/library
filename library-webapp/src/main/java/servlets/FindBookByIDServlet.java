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

public class FindBookByIDServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idFromField = req.getParameter("ID");
        BookDAO book = new PostgreSQLBookDAO();
        Validator validator = new Validator();
        if (validator.isIDCorrect(idFromField)) {
            Long id = Long.parseLong(idFromField);
            try {
                req.setAttribute("result", book.getBook(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
