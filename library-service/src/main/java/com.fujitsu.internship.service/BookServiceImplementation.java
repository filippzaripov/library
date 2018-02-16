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
    public boolean editBook(long id, String name, BookCategory category, Author author) {
        if (validator.validateNewBookField(name, category.getName()) && author != null) {
            return bookDAO.editBook(id, name, category, author);
        } else {
            return false;
        }
    }

    @Override
    public Book getBook(long id) {
        return bookDAO.get(id);
    }

    @Override
    public Long createBook(Book book) {
        String name = book.getName();
        Author author = book.getAuthor();
        if (validator.validateNewBookField(name, author.getName())) {
            return bookDAO.create(book);
        } else {
            return -1L;
        }
    }

    @Override
    public boolean deleteBook(long id) {
        return getBook(id) != null && bookDAO.delete(id) ? true : false;
    }


    public List<Book> getAllBooksPaging(int pageSize, int pageNumber) {
        return bookDAO.getAllBooksPaging(pageSize, (pageNumber - 1) * pageSize);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }
}
