package fizzbuzz;

import org.junit.Test;
import static org.junit.Assert.*;


public class FizzBuzzTests {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void oneShouldReturnOne(){
     String result = fizzBuzz.fizzBuzz(1);
     assertEquals("1", result);
    }



}
