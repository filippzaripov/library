package com.fujitsu.internship.dao;

import java.util.ArrayList;
import com.fujitsu.internship.model.Book;
/**
 * This intreface is for work with Database.
 *  @author Filipp Zaripov
 */
public interface BookDAO {

    /**
     * Method that gets Book object from Database. Search by ID of the Book.
     * @param id using for searching Book in DB
     * @return Book object
     * @throws Exception
     */
    Book getBook(long id);

    /**
     * This method returns all books from Database
     * @return returns all books from Database
     * @throws Exception
     */
    ArrayList<Book> getAll();

    /**
     * This method deletes book by ID from Database
     * @param id using for searching Book in DB
     * @throws Exception
     */
    void delete(long id);

    /**
     * This method creates new book and add it to Database
     * @param book this is book object that should be added
     * @throws Exception
     */
    void addBook(Book book);

}
