package com.fujitsu.internship.DAO;
import com.fujitsu.internship.Book;

import java.util.ArrayList;

public interface BookDAO {

    Book getBook(long id) throws Exception;
    ArrayList<Book> getAll() throws Exception;
    Book delete(long id) throws Exception;
    Book save(Book book) throws Exception;

}
