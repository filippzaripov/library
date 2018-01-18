import com.fujitsu.internship.dao.Validator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ValidatorTest extends Assert {
    Validator validator = new Validator();

    @Test
    public void testValidateNewBook() {
        assertFalse(validator.validateNewBookField(null, null));
        assertFalse(validator.validateNewBookField(null, ""));
        assertFalse(validator.validateNewBookField("", null));
        assertFalse(validator.validateNewBookField("", ""));
        assertFalse(validator.validateNewBookField("name of the book", "nonexistent category"));
        //check creating with existent category
        assertTrue(validator.validateNewBookField("name of the book", "historical"));
    }

    @Test
    public void testIdCorrect() {
        assertFalse(validator.isIDCorrect(-1L));
        assertFalse(validator.isIDCorrect(0L));
        assertFalse(validator.isIDCorrect(null));
        assertTrue(validator.isIDCorrect(1L));
        assertFalse(validator.isIDCorrect(1234567899999L));
    }

}
