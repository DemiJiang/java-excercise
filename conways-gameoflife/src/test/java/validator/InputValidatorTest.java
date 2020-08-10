package validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidatorTest {

    @Test
    public void shouldReturnTrue_WhenPositiveInteger() {
        assertTrue(InputValidator.isPositiveInteger("2"));
    }

    @Test
    public void shouldReturnFalse_WhenInvalidPositiveInteger() {
        assertFalse(InputValidator.isPositiveInteger("-8"));
    }
}
