package com.fujitsu.internship.DAO;
import com.fujitsu.internship.Book;

public interface BookDAO {

    Book getID(long id);
    Book getAll();
    Book delete(long id);
    Book save(Book book);

}
