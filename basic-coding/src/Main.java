import fizzbuzz.FizzBuzz;

import java.awt.desktop.SystemEventListener;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(new int[]{15}));

        System.out.println(IntStream.rangeClosed(1,17).toArray());
    }

}
