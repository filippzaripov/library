import com.fujitsu.internship.dao.Validator;
import junit.framework.TestCase;
import org.junit.Test;

public class ValidatorTest extends TestCase {
    Validator validator = new Validator();
    @Test
    public void testValidateNewBook(){

        boolean isValidate = validator.validateNewBookField(null,null);
        assertFalse(isValidate);

        isValidate = validator.validateNewBookField(null, "");
        assertFalse(isValidate);

        isValidate = validator.validateNewBookField("",null);
        assertFalse(isValidate);

        isValidate = validator.validateNewBookField("","");
        assertFalse(isValidate);

        isValidate = validator.validateNewBookField("name of the book", "nonexistent category");
        assertFalse(isValidate);

        //check creating with existent category
        isValidate = validator.validateNewBookField("name of the book", "historical");
        assertTrue(isValidate);
    }

    public void testIdIDCorrect(){
        boolean isValidate = validator.isIDCorrect("0");
        assertFalse(isValidate);

        isValidate = validator.isIDCorrect("012");
        assertFalse(isValidate);

        isValidate = validator.isIDCorrect("abc");
        assertFalse(isValidate);

        isValidate = validator.isIDCorrect(" ");
        assertFalse(isValidate);

        isValidate = validator.isIDCorrect(null);
        assertFalse(isValidate);

        isValidate = validator.isIDCorrect("1");
        assertTrue(isValidate);
    }

}
