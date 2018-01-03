package dao.pg;

import dao.BookDAO;

import java.sql.*;
import java.util.ArrayList;
import model.Book;


public class PostgreSQLBookDAO implements BookDAO {
    PostgreSQLConnector connector = new PostgreSQLConnector();

    public Book getBook(long id) throws SQLException{
        Connection connection = connector.getConnection();
            Book book = null;

            try {
                    PreparedStatement stmt = connection.prepareStatement("SELECT ID,name,category_name FROM books WHERE ID = ?");
                    stmt.setLong(1, id);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()) {
                        book = new Book(rs.getInt("ID"), rs.getString("name"), rs.getString("category_name"));
                    }
                    rs.close();
                    stmt.close();
                } catch (Exception e){
                System.err.println("class : PostgreSQLBookDAO, line : 26");
                //TODO: make my own exception class
                } finally {
                    connection.close();
                }
            return book;
    }

    public ArrayList<Book> getAll() throws Exception {
        Connection connection = connector.getConnection();
        ArrayList<Book> bookList = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT ID,name,category_name FROM books");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                bookList.add(new Book(rs.getLong("ID"), rs.getString("name"), rs.getString("category_name")));
            }
            rs.close();
            stmt.close();
        } catch (Exception e){
            System.err.println("class : PostgreSQLBookDAO, line : 45");
            //TODO: make my own exception class
        } finally {
            connection.close();
        }
        return bookList;
    }

    public void delete(long id) throws Exception {
        Connection connection = connector.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM books WHERE ID = ?");
            stmt.setInt(1, (int)id);
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            System.err.println("class : PostgreSQLBookDAO, line : 61");
        }finally {
            connection.close();
        }
    }

    public void addBook(Book book)throws Exception {
        Connection connection = connector.getConnection();

        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO books (name, category_name) VALUES (? , ?)");
            stmt.setString(1,book.getName());
            stmt.setString(2, book.getCategory_name());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            System.err.println("class : PostgreSQLBookDAO, line : 77");
        }finally {
            connection.close();
        }
    }
}
