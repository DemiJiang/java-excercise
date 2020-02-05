package fizzbuzz;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;


public class FizzBuzzTests {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void oneShouldReturnOne(){
     String result = fizzBuzz.fizzBuzz(new int[]{1});
     assertEquals("1", result);
    }

    @Test
    public void threeShouldReturnFizz(){
        String result = fizzBuzz.fizzBuzz(new int[]{3});
        assertEquals("Fizz", result);
    }

    @Test
    public void fiveShouldReturnBuzz(){
        String result = fizzBuzz.fizzBuzz(new int[]{5});
        assertEquals("Buzz", result);
    }

    @Test
    public void sixShouldReturnFizz(){
        String result = fizzBuzz.fizzBuzz(new int[]{6});
        assertEquals("Fizz", result);
    }

    @Test
    public void fifteenShouldReturnFizzBuzz(){
        String result = fizzBuzz.fizzBuzz(new int[]{15});
        assertEquals("FizzBuzz", result);
    }

    @Test
    public void multipleShouldReturnMultipleFizzBuzz(){
//        String result = fizzBuzz.fizzBuzz(IntStream.rangeClosed(1,17).toArray());
        String result = fizzBuzz.fizzBuzz(17);
        assertEquals("12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz1617", result);
    }


}
