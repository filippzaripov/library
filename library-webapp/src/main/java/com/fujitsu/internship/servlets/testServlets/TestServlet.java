package com.fujitsu.internship.servlets.testServlets;


import com.fujitsu.internship.dao.pg.PostgreSQLConnector;
import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostgreSQLConnector connector = PostgreSQLConnector.getConnector();
        Connection connection = connector.getConnection();
        ArrayList<Book> books = new ArrayList();
        List<Book> testList = new LinkedList();
        testList.add(new Book("book1", new BookCategory("kids")));
        testList.add(new Book("book2", new BookCategory("kids")));
        testList.add(new Book("book3", new BookCategory("kids")));
        /*try{
            PreparedStatement stmt = connection.prepareStatement("select id, name, category_name, author from books where id = ?");
            stmt.setLong(1, 1);
            ResultSet rs = stmt.executeQuery();
            Book book = null;
            while (rs.next()){
                books.add(new Book(rs.getLong("id"),rs.getString("name"), new BookCategory(rs.getString("category_name")), new Author(rs.getString("author"))));
            }*/
            req.setAttribute("bookList", testList);
            req.getRequestDispatcher("test.jsp").forward(req, resp);

        /*}catch(SQLException e){
            System.err.println("SQL exception in test Servlet");
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
