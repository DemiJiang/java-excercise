public class InputValidator {
    public static boolean isValidFormat(String input){
        if(input.contains(",") && input.length() == 3 && !input.contains("0"))
            return input.replace(",", "").chars().allMatch(Character::isDigit);
        return false;
    }

    public static boolean isValidInputWithBoardRange(String input, int boardLength){
        String[] stringArrayOfInput = input.split(",");
        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[0] = Integer.parseInt(stringArrayOfInput[0]);
        arrayFromSplitInput[1] = Integer.parseInt(stringArrayOfInput[1]);
        return arrayFromSplitInput[0] <= boardLength && arrayFromSplitInput[1] <= boardLength;
    }


    public static boolean isQuitKeyword(String input) {
        return input.toLowerCase().contains("q");
    }

    public static Coordinates inputToCoordinate(String input){
        String[] moves = input.split(",");
        return new Coordinates(Integer.parseInt(moves[0]) - 1, Integer.parseInt(moves[1]) - 1);
    }
}
