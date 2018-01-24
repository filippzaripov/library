package com.fujitsu.internship.dao;

import com.fujitsu.internship.model.Book;

import java.util.List;

/**
 * @author Filipp Zaripov
 * @see com.fujitsu.internship.dao.GenericDAO
 * Each method throws DataAccessException
 */
public interface BookDAO extends GenericDAO<Book> {

    @Override
    Book create(Book book) throws DataAccessException;

    @Override
    Book get(Long id) throws DataAccessException;

    @Override
    boolean delete(long id);

    /**
     * @return all books as List or empty list if none found.
     */
    List<Book> getAll() throws DataAccessException;
}
