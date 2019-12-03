import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTests {
    @Test
    public void checkAValid10DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value",result);
        result = validator.checkISBN("0856761532");
        assertTrue("second value", result);
    }

    @Test
    public void TenDigitISBNNUmbersEndingInAnXAreValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("000820148X");
        assertTrue(result);
    }

    @Test
    public void thirteenDigitsISBNAreValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780008201494");
        assertTrue(result);
        result = validator.checkISBN("9780140449266");
        assertTrue(result);
    }

    @Test
    public void checkAnInvalid10DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkAnInvalid13DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780140449267");
        assertFalse(result);
    }

    //uncheked exception
    @Test (expected = NumberFormatException.class)
    public void nineDigitsISBNNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }

    @Test (expected = NumberFormatException.class)
    public void nonNumericISBNsNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloworld");
    }



}
