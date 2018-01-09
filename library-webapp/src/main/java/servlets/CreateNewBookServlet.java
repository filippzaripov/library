package servlets;

import dao.BookDAO;
import dao.Validator;
import dao.pg.PostgreSQLBookDAO;
import model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateNewBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new PostgreSQLBookDAO();
        String name= req.getParameter("name");
        String category = req.getParameter("category_name");
        Validator validator = new Validator();
        if (validator.validateNewBookField(name, category)){
            try{
                bookDAO.addBook(new Book(name,category));
                req.setAttribute("result", "Book "+ name +" was added to database");
                //TODO: make my own exception
            }catch(Exception e){
                System.err.println("class : CreateNewBookServlet , line : 25");
            }
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
