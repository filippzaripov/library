import com.fujitsu.internship.dao.pg.PostgreSQLConnector;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * For testing PostgreSQLConnector
 */
public class PostgreSQLConnectorTest extends TestCase {
PostgreSQLConnector connector = PostgreSQLConnector.getConnector();
    @Test
    public void testGetConnection() {
        assertNotNull(connector.getConnection());
    }
}
