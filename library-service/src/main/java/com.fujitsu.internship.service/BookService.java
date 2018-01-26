package com.fujitsu.internship.service;

import com.fujitsu.internship.model.Book;

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
     * @return all books as List or empty list if none found.
     */
    //FIXME: add sorting (order By)
    List<Book> getAllBooks();

}
