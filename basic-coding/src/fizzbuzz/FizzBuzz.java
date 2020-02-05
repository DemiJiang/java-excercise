package fizzbuzz;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FizzBuzz {

    public String fizzBuzz(int[] numbers) {
        StringBuilder fizzbuzz = new StringBuilder();
        for (int number : numbers) {
            fizzbuzz.append(getFizzBuzz(number));
        }
        return fizzbuzz.toString();
    }

    public String fizzBuzzone(int[] numbers){
        String fizzbuzz = "";
        for (int number : numbers) {
            fizzbuzz += getFizzBuzz(number);
        }

        return fizzbuzz;
    }
    private Map<Function<Integer, Boolean>, String> rules = initRules();

    private static Map<Function<Integer, Boolean>, String> initRules() {
        Map<Function<Integer, Boolean>, String> rules = new HashMap<>();
        rules.put(number -> number % 3 == 0 && number % 5 == 0, "FizzBuzz");
        rules.put(number -> number % 3 == 0 && !(number % 5 == 0), "Fizz");
        rules.put(number -> !(number % 3 == 0) && number % 5 == 0, "Buzz");
        return rules;
    }

    private String getFizzBuzz(int number) {
        for (Function<Integer, Boolean> rule : rules.keySet()) {
            if(rule.apply(number)) return rules.get(rule);
        }
        return String.valueOf(number);
    }

    public String fizzBuzz(int number) {
        String result = "";
        for (int i = 1; i < number + 1; i++) {
            result = result + getFizzBuzz(i);
        }
        return result;
    }
}
