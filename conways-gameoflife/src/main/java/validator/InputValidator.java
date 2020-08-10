package validator;

public class InputValidator {

    public static boolean isPositiveInteger(String input) {
        if (!input.isEmpty()) {
            return input.chars().allMatch(Character::isDigit) && Integer.parseInt(input) > 0;
        }
        return false;
    }
}
