import com.fujitsu.internship.dao.BookDAO;
import com.fujitsu.internship.dao.DataAccessException;
import com.fujitsu.internship.dao.pg.PostgreSQLBookDAO;
import com.fujitsu.internship.dao.pg.PostgreSQLConnector;
import com.fujitsu.internship.model.Book;
import com.fujitsu.internship.model.BookCategory;
import org.junit.*;

import java.sql.*;

/**
 * Test for PostgreSQLBookDAO class
 */
@Ignore
public class PSQLBookDAOTest extends Assert {
    private BookDAO bookDAO = new PostgreSQLBookDAO();
    protected PostgreSQLConnector connector = PostgreSQLConnector.getConnector();
    private BookCategory testCategory = new BookCategory("test category");
    private String nameOfTestBook = "test name that nobody never write";

    @Before
    public void setUpNewBooksCategory() {
        try (Connection connection = connector.getConnection();
             PreparedStatement newCategoryStmt = connection.prepareStatement("INSERT INTO books_cat (category_name) VALUES (?)")) {
            newCategoryStmt.setString(1, testCategory.getName());
            newCategoryStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while creating test category", e);
        }
    }

    @Test
    public void testAddBook() {
        Long id = bookDAO.addBook(new Book(nameOfTestBook, testCategory));
        assertNotNull(id);
        Book book = bookDAO.getBook(id);
        assertEquals(book.getName(), nameOfTestBook);
        bookDAO.delete(book.getId());
    }


    @Test
    public void testGetBook() {
        long id = bookDAO.addBook(new Book(nameOfTestBook, testCategory));
        Book book = bookDAO.getBook(id);
        assertNotNull(book);
        assertEquals(nameOfTestBook, book.getName());
        bookDAO.delete(book.getId());
    }

    @Test
    public void testGetMissedBook() {
        assertNull(bookDAO.getBook(-1));
    }

    @Test
    public void testDelete() {
       Long id = bookDAO.addBook(new Book(nameOfTestBook, testCategory));
        Book book = bookDAO.getBook(id);
        assertTrue(bookDAO.delete(book.getId()));
        assertNull(bookDAO.getBook(id));
    }

    @Test
    public void testGetAll() {
       Long id = bookDAO.addBook(new Book(nameOfTestBook, testCategory));
        assertNotNull(bookDAO.getAll());
        bookDAO.delete(id);
    }

    @After
    public void deleteNewBooksCategory() {
        try (Connection connection = connector.getConnection();
             PreparedStatement newCategoryStmt = connection.prepareStatement("DELETE FROM books_cat WHERE category_name = ?")) {
            newCategoryStmt.setString(1, testCategory.getName());
            newCategoryStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while creating test category", e);
        }
    }

}
