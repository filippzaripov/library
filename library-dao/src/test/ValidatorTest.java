import com.fujitsu.internship.dao.Validator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ValidatorTest extends Assert {
    Validator validator = new Validator();

    @Test
    public void testValidateNewBook() {

        boolean isValidate = validator.validateNewBookField(null, null);
        assertFalse(isValidate);

        isValidate = validator.validateNewBookField(null, "");
        assertFalse(isValidate);

        isValidate = validator.validateNewBookField("", null);
        assertFalse(isValidate);

        isValidate = validator.validateNewBookField("", "");
        assertFalse(isValidate);

        isValidate = validator.validateNewBookField("name of the book", "nonexistent category");
        assertFalse(isValidate);

        //check creating with existent category
        isValidate = validator.validateNewBookField("name of the book", "historical");
        assertTrue(isValidate);
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
