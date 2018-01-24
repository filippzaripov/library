package com.fujitsu.internship.service;

import com.fujitsu.internship.dao.BookDAO;
import com.fujitsu.internship.dao.pg.PostgreSQLBookDAO;
import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;

import java.util.List;

/**
 * BookService implementation \
 *
 * @see BookService
 */
public class BookServiceImplementation implements BookService {
    protected BookDAO bookDAO = new PostgreSQLBookDAO();
    protected Validator validator = new Validator();

    @Override
    public Book getBook(long id) {
        return bookDAO.get(id);
    }

    @Override
    public Book createBook(Book book) {
        String name = book.getName();
        BookCategory categoryName = book.getCategory();
        if (validator.validateNewBookField(name, categoryName.getName())) {
            return bookDAO.create(book);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteBook(long id) {
        return getBook(id) != null && bookDAO.delete(id) ? true : false;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }
}
