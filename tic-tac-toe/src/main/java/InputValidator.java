public class InputValidator {
    public static boolean isValidFormat(String input){
        if(input.contains(",") && input.length() == 3 && !input.contains("0"))
            return input.replace(",", "").chars().allMatch(Character::isDigit);
        return false;
    }

//    public boolean isValidMove(int xPosition, int yPosition) {
//        if(xPosition < 0 || xPosition > 3 || yPosition < 0 || yPosition > 3)
//            return false;
//        if(board.getBoard()[xPosition][yPosition] != '.')
//            return false;
//        return true;
//    }

    public static Coordinates inputToCoordinate(String input){
        String[] moves = input.split(",");
        return new Coordinates(Integer.parseInt(moves[0]) - 1, Integer.parseInt(moves[1]) - 1);
    }
}
