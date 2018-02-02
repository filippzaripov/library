package com.fujitsu.internship.service;

import com.fujitsu.internship.model.Author;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;

import java.util.List;

public interface BookService {

    /**
     * Retrieves a book by its id
     *
     * @param id the id of the book to retrieve
     * @return the book with given id or {@code null} if none found.
     */
    Book getBook(long id);

    /**
     * Creates new book
     *
     * @param book book that should be created
     * @return book that has been created, {@code null} if book wasn't created
     */
    //FIXME: delete null
    Book createBook(Book book);

    /**
     * deletes book by id
     *
     * @param id using for searching Book
     * @return true if was delete successfully, in any other cases returns false
     */
    boolean deleteBook(long id);

    /**
     *
     * @return all books as List ordered by id or empty list if none found.
     */

    List<Book> getAllBooks();

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
