package com.fujitsu.internship.dao.pg;

import com.fujitsu.internship.dao.BookDAO;
import com.fujitsu.internship.dao.DataAccessException;
import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements BookDAO interface and manipulates with Database
 *
 * @author Filipp Zaripov
 * @see com.fujitsu.internship.dao.BookDAO
 */
public class PostgreSQLBookDAO implements BookDAO {
    protected PostgreSQLConnector connector = PostgreSQLConnector.getConnector();
    private static Logger log = LoggerFactory.getLogger(PostgreSQLConnector.class);

    public Book getBook(long id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT id,name,category_name,author FROM books WHERE ID = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? createBook(rs) : null;
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while getting book", e);
        }
    }

    protected Book createBook(ResultSet rs) throws SQLException {
        return new Book(rs.getLong("id"), rs.getString("name"), new BookCategory(rs.getString("category_name")),new Author(rs.getString("author")) );
    }

    public Book getBookByName(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT id, name, category_name,author FROM books WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? createBook(rs) : null;
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while get book be name test", e);
        }
    }

    public List<Book> getAll() {
        List<Book> bookList = new ArrayList();
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT id,name,category_name,author FROM books");
        ) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookList.add(createBook(rs));
            }
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while get all books", e);
        }
        return bookList;
    }

    public boolean delete(long id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM books WHERE ID = ?")) {
            stmt.setLong(1, id);
            Book book = getBook(id);
            stmt.executeUpdate();
            log.info("Book {} was removed", book);
            return true;
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while delete book", e);
        }
    }

    public Long addBook(Book book) {
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO books (name, category_name, author) VALUES (? , ?, ?)")) {
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getCategory().getName());
            stmt.setString(3, book.getAuthor().getName());
            stmt.executeUpdate();
            Book addedBook = getBookByName(book.getName());
            if (addedBook != null) {
                log.info("book {} was added", addedBook);
                return addedBook.getId();
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while adding book", e);
        }
    }
}
