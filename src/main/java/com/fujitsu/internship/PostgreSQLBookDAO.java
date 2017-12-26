package com.fujitsu.internship;

import com.fujitsu.internship.DAO.BookDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PostgreSQLBookDAO implements BookDAO {

    Connection connection = PostgreSQLConnector.getConnection();

    public Book getBook(long id) throws SQLException{
            Book book = null;
            try {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM books WHERE ID=" + id);
                    while(rs.next()) {
                        book = new Book(rs.getLong("ID"), rs.getString("name"), rs.getString("category_name"));
                    }
                    rs.close();
                    stmt.close();
                } catch (Exception e){

                } finally {
                    connection.close();
                }
            return book;
    }

    public ArrayList<Book> getAll() throws Exception {
        ArrayList<Book> bookList = new ArrayList();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            System.out.println("ID" + " | " + "NAME");
            while (rs.next()){
                bookList.add(new Book(rs.getLong("ID"), rs.getString("name"), rs.getString("category_name")));
            }

            rs.close();
            stmt.close();
        } catch (Exception e){

        } finally {
            connection.close();
        }
        return bookList;
    }

    public Book delete(long id) throws Exception {
        return null;
    }

    public Book save(Book book )throws Exception {
        return null;
    }
}
