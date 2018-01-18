package com.fujitsu.internship.dao;

import java.util.ArrayList;
import java.util.List;

import com.fujitsu.internship.model.Book;
/**
 *  Interface
 *  @author Filipp Zaripov
 *  Each method throws DataAccessException
 */
public interface BookDAO {

    /**
     * Retrieves a book by its id
     * @param id the id of the book to retrieve, must not be null
     * @return the book with given id or {@code null} if none found.
     */
    Book getBook(long id) throws DataAccessException;

    /**
     * @return all books as List or {@code null} if none found.
     */
    List<Book> getAll()throws DataAccessException;

    /**
     * deletes book by id
     * if book wasn't found shows message that id isn't correct
     * @param id using for searching Book
     * @return id of deleted book, {@code null} if none found
     */
    Long delete(long id)throws DataAccessException;

    /**
     * Add new book to storage.
     * If id wasn't found show message that book was not found.
     * @param book book object that should be added to storage
     * @return id of added book {@code null} if book wasn't added
     */
    Long addBook(Book book)throws DataAccessException;

}
