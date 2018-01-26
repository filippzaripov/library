package com.fujitsu.internship.dao;

import com.fujitsu.internship.model.Book;

import java.util.List;

/**
 * @author Filipp Zaripov
 * @see com.fujitsu.internship.dao.GenericDAO
 * Each method throws DataAccessException
 */
public interface BookDAO extends GenericDAO<Book> {

    /**
     * @return all books as List or empty list if none found.
     */
    List<Book> getAll();
}
