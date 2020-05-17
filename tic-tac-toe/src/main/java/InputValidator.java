public class InputValidator {
    public static boolean isValidFormat(String input){
        if(input.contains(",") && input.length() == 3 && !input.contains("0"))
            return input.replace(",", "").chars().allMatch(Character::isDigit);
        return false;
    }

    public static Coordinates inputToCoordinate(String input){
        String[] moves = input.split(",");
        return new Coordinates(Integer.parseInt(moves[0]) - 1, Integer.parseInt(moves[1]) - 1);
    }
}
