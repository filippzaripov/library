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
        return bookDAO.getBook(id);
    }

    @Override
    public Book createBook(Book book) {
        long id;
        String name = book.getName();
        BookCategory categoryName = book.getCategory();
        Author author = book.getAuthor();
        if (validator.validateNewBookField(name, categoryName.getName())) {
            id = bookDAO.addBook(new Book(name, categoryName, author));
            return getBook(id);
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
