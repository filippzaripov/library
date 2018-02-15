package com.fujitsu.internship.dao;

import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;

import java.util.List;

/**
 * @author Filipp Zaripov
 * @see com.fujitsu.internship.dao.GenericDAO
 * Each method throws DataAccessException
 */
public interface BookDAO extends GenericDAO<Book> {

    /**
     * @param limit limit in the SQL request
     * @param offset offset in the SQL request
     * @return all books as List or empty list if none found.
     */
    List<Book> getAllBooksPaging(int limit, int offset);

    /**
     * @return all books as List or empty list if none found.
     */
    List<Book> getAll();

    /**
     * updates book in table
     *
     * @param id       id of the book
     * @param name     new name of the book, should not be null
     * @param category book category shouldn't be null
     * @param author   author of the book, shouldn't be null
     * @return true if books was successfully updates, else - false
     */
    boolean editBook(long id, String name, BookCategory category, Author author);

}
