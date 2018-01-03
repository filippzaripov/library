package servlets;

import dao.BookDAO;
import dao.pg.PostgreSQLBookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteBookServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new PostgreSQLBookDAO();
        long id = Long.parseLong(req.getParameter("ID_to_delete"));
        try{
            String name = bookDAO.getBook(id).getName();
            bookDAO.delete(id);
            req.setAttribute("result", "Book "+ name +" was removed from database");
        }catch (Exception e){
            System.err.println("class : DeleteBookServlet , line : 24");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
