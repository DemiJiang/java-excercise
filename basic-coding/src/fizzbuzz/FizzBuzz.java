package fizzbuzz;

public class FizzBuzz {

    public String fizzBuzz(int[] numbers) {
        String fizzbuzz = "";
        for (int i = 0; i < numbers.length; i++){
         fizzbuzz = fizzbuzz + getFizzBuzz(numbers[i]);
        }
        return fizzbuzz;
    }

    private String getFizzBuzz(int number) {
        if (isFizz(number) && isBuzz(number))
            return "FizzBuzz";
        else if (isBuzz(number))
            return "Buzz";
        else if (isFizz(number))
            return "Fizz";
        return String.valueOf(number);
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }

}
