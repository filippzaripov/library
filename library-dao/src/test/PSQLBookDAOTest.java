import com.fujitsu.internship.dao.BookDAO;
import com.fujitsu.internship.dao.DataAccessException;
import com.fujitsu.internship.dao.pg.PostgreSQLBookDAO;
import com.fujitsu.internship.dao.pg.PostgreSQLConnector;
import com.fujitsu.internship.model.Book;
import org.junit.*;

import java.sql.*;

/**
 * Test for PostgreSQLBookDAO class
 */
public class PSQLBookDAOTest extends Assert {
    private BookDAO bookDAO = new PostgreSQLBookDAO();
    protected PostgreSQLConnector connector = PostgreSQLConnector.getConnector();
    private String nameOfTestCategory = "test category";
    private String nameOfTestBook = "test name that nobody never write";

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
        Long id = bookDAO.addBook(new Book(nameOfTestBook, nameOfTestCategory));
        assertNotNull(id);
        Book book = bookDAO.getBook(id);
        assertEquals(book.getName(), nameOfTestBook);
        bookDAO.delete(book.getId());
    }

    @Test
    public void testAddEmptyBook(){
        assertNull(bookDAO.addBook(new Book("","")));
    }

    @Test
    public void testGetBook() {
        long id = bookDAO.addBook(new Book(nameOfTestBook, nameOfTestCategory));
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
       Long id = bookDAO.addBook(new Book(nameOfTestBook, nameOfTestCategory));
        Book book = bookDAO.getBook(id);
        assertEquals(book.getId(), (long) bookDAO.delete(book.getId()));
        assertNull(bookDAO.getBook(id));
    }

    @Test
    public void testDeleteMissedBook() {
        assertNull(bookDAO.delete(-1));
    }

    @Test
    public void testGetAll() {
       Long id = bookDAO.addBook(new Book(nameOfTestBook, nameOfTestCategory));
        assertNotNull(bookDAO.getAll());
        bookDAO.delete(id);
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
