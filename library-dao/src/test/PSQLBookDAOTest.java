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
    private String nameOfTestCategory = "test_category";
    private String nameOfTestBook = "test_name_that_nobody_never_write";

    private Book getBookByName(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT id, name, category_name FROM books WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? new Book(rs.getLong("id"), rs.getString("name"), rs.getString("category_name")) : null;
        } catch (SQLException e) {
            throw new DataAccessException("SQL Exception while get book be name test", e);
        }
    }

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
        bookDAO.addBook(new Book(nameOfTestBook, nameOfTestCategory));
        Book book = getBookByName(nameOfTestBook);
        assertNotNull(book);
        assertEquals(book.getName(), nameOfTestBook);
        bookDAO.delete(book.getId());
    }
    @Test
    public void testGetBook(){
        bookDAO.addBook(new Book(nameOfTestBook, nameOfTestCategory));
        long id = getBookByName(nameOfTestBook).getId();
        Book book = bookDAO.getBook(id);
        assertNotNull(book);
        assertEquals(nameOfTestBook,book.getName());
        bookDAO.delete(book.getId());
    }

    @Test
    public void testGetMissedBook() {
        assertNull(bookDAO.getBook(-1));
    }

    @Test
    public void testDelete() {
        bookDAO.addBook(new Book(nameOfTestBook, nameOfTestCategory));
        Book book = getBookByName(nameOfTestBook);
        assertEquals(book.getId(), (long) bookDAO.delete(book.getId()));
        assertNull(getBookByName(nameOfTestBook));
    }

    @Test
    public void testDeleteMissedBook() {
        assertNull(bookDAO.delete(-1));
    }

    @Test
    public void testGetAll() {
        bookDAO.addBook(new Book(nameOfTestBook, nameOfTestCategory));
        assertNotNull(bookDAO.getAll());
        bookDAO.delete(getBookByName(nameOfTestBook).getId());
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
