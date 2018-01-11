package dao.pg;

import dao.BookDAO;

import java.sql.*;
import java.util.ArrayList;
import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This class implements BookDAO interface and manipulates with Database
 * @see dao.BookDAO
 * @author Filipp Zaripov
 *
 */
public class PostgreSQLBookDAO implements BookDAO {
    PostgreSQLConnector connector = new PostgreSQLConnector();
    private static Logger log = LoggerFactory.getLogger(PostgreSQLConnector.class);
    public Book getBook(long id) {
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
                } catch (SQLException e){
                    log.error("SQL Exception while getting book", e);
                } finally {
                try {
                    connection.close();
                }catch (SQLException e){
                    log.error("SQL Exception while closing connection and get book", e);
                }
                }
            return book;
    }

    public ArrayList<Book> getAll(){
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
        } catch (SQLException e){
            log.error("SQL Exception while get all books", e);
        } finally {
            try {
                connection.close();
            }catch (SQLException e){
                log.error("SQL Exception while closing connection", e);
            }
        }
        return bookList;
    }

    public void delete(long id)  {
        Connection connection = connector.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM books WHERE ID = ?");
            stmt.setInt(1, (int)id);
            Book book = getBook(id);
            stmt.execute();
            stmt.close();
            log.info("Book '{}' was removed", book);
        }catch (SQLException e){
            log.error("SQL Exception while delete book", e);
        }finally {
            try {
                connection.close();
            }catch (SQLException e){
                log.error("SQL Exception while closing connection while delete book", e);
            }
        }
    }

    public void addBook(Book book) {
        Connection connection = connector.getConnection();

        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO books (name, category_name) VALUES (? , ?)");
            stmt.setString(1,book.getName());
            stmt.setString(2, book.getCategory_name());
            stmt.executeUpdate();
            log.info("book '{}' was added", book);
            stmt.close();
        }catch(SQLException e){
            System.err.println("class : PostgreSQLBookDAO, line : 77");
            log.error("SQL Exception while adding book", e);
        }finally {
            try {
                connection.close();
            }catch (SQLException e){
                log.error("SQL Exception while closing connection while adding new book", e);
            }

        }
    }
}
