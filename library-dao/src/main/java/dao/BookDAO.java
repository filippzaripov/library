package dao;

import java.util.ArrayList;
import model.Book;

public interface BookDAO {

    Book getBook(long id) throws Exception;
    ArrayList<Book> getAll() throws Exception;
    void delete(long id) throws Exception;
    void addBook(Book book) throws Exception;

}
