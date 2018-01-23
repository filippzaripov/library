import com.fujitsu.internship.dao.DataAccessException;
import com.fujitsu.internship.dao.pg.PostgreSQLConnector;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.service.BookService;
import com.fujitsu.internship.service.BookServiceImplementation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookServiceImplementationTest extends Assert {
    PostgreSQLConnector connector = PostgreSQLConnector.getConnector();
    private String nameOfTestCategory = "test category";
    private String nameOfTestBook = "test name that nobody never write";
    protected BookService bookService = new BookServiceImplementation();

    @Before
    public void setUpNewBooksCategory() {
        try (Connection connection = connector.getConnection();
             PreparedStatement newCategoryStmt = connection.prepareStatement("INSERT INTO books_cat (category_name) VALUES (?)")) {
            newCategoryStmt.setString(1, nameOfTestCategory);
            newCategoryStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while creating test category", e);
        }
    }

    @Test
    public void testAddBook() {
        Book book = bookService.createBook(new Book(nameOfTestBook, nameOfTestCategory));
        assertNotNull(book.getId());
        assertEquals(book.getName(), nameOfTestBook);
        bookService.deleteBook(book.getId());
    }

    @Test
    public void testAddEmptyBook(){
        assertNull(bookService.createBook(new Book("","")));
    }

    @Test
    public void testGetBook() {
        Book book = bookService.createBook(new Book(nameOfTestBook, nameOfTestCategory));
        assertNotNull(book);
        assertEquals(nameOfTestBook, book.getName());
        bookService.deleteBook(book.getId());
    }

    @Test
    public void testGetMissedBook() {
        assertNull(bookService.getBook(-1));
    }

    @Test
    public void testDelete() {
        Book book = bookService.createBook(new Book(nameOfTestBook, nameOfTestCategory));
        assertTrue(bookService.deleteBook(book.getId()));
        assertNull(bookService.getBook(book.getId()));
    }

    @Test
    public void testGetAll() {
        Book book = bookService.createBook(new Book(nameOfTestBook, nameOfTestCategory));
        assertNotNull(bookService.getAllBooks());
        bookService.deleteBook(book.getId());
    }

    @After
    public void deleteNewBooksCategory() {
        try (Connection connection = connector.getConnection();
             PreparedStatement newCategoryStmt = connection.prepareStatement("DELETE FROM books_cat WHERE category_name = ?")) {
            newCategoryStmt.setString(1, nameOfTestCategory);
            newCategoryStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while creating test category", e);
        }
    }

}
