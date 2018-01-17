package com.fujitsu.internship.dao.pg;

import com.fujitsu.internship.dao.BookDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.fujitsu.internship.dao.DataAccessException;
import com.fujitsu.internship.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements BookDAO interface and manipulates with Database
 *
 * @author Filipp Zaripov
 * @see com.fujitsu.internship.dao.BookDAO
 */
public class PostgreSQLBookDAO implements BookDAO {
    protected PostgreSQLConnector connector = PostgreSQLConnector.getConnector();
    private static Logger log = LoggerFactory.getLogger(PostgreSQLConnector.class);

    public Book getBook(long id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT id,name,category_name FROM books WHERE ID = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? createBook(rs) : null;
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while getting book", e);
        }
    }

    protected Book createBook(ResultSet rs) throws SQLException {
        return new Book(rs.getLong("id"), rs.getString("name"), rs.getString("category_name"));
    }

    public List<Book> getAll() {
        List<Book> bookList = new ArrayList();
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT id,name,category_name FROM books");
        ) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookList.add(new Book(rs.getLong("id"), rs.getString("name"), rs.getString("category_name")));
            }
            return !bookList.isEmpty() ? bookList : null;
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while get all books", e);
        }
    }

    public Long delete(long id) {

        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM books WHERE ID = ?")) {
            stmt.setLong(1, id);
            Book book = getBook(id);
            if (book != null) {
                stmt.executeUpdate();
                log.info("Book '{}' was removed", book);
                return book.getId();
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while delete book", e);
        }
    }

    public void addBook(Book book) {
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO books (name, category_name) VALUES (? , ?)")) {
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getCategory_name());
            stmt.executeUpdate();
            log.info("book '{}' was added", book);
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while adding book", e);
        }
    }
}
