import java.util.ArrayList;

public class Winner {
    public Player getWinner(Board board, ArrayList<Player> players) {
        char rowSymbol = rowCrossed(board);
        char colSymbol = columnCrossed(board);
        char diagonalSymbol = diagonalCrossed(board);
        for(Player player : players){
            if(player.getMark() == rowSymbol) return player;
            if(player.getMark() == colSymbol) return player;
            if(player.getMark() == diagonalSymbol) return player;
        }
        return null;
    }

    private char rowCrossed(Board board){
        for(int i = 0; i < 3; i++){
            char check = board.getBoard()[i][0];
            for(int j = 1; j < 3; j++){
                if(check != board.getBoard()[i][j]){
                    check = '.';
                    break;
                }
            }
            if(check != '.'){
                return check;
            }
        }
        return '.';
    }

    private char columnCrossed(Board board){
        for(int i = 0; i < 3; i++){
            char check = board.getBoard()[0][i];
            for(int j = 1; j < 3; j++){
                if(check != board.getBoard()[j][i]){
                    check = '.';
                    break;
                }
            }
            if(check != '.')
                return check;
        }
        return '.';
    }

    private char diagonalCrossed(Board board){
        char check = board.getBoard()[0][0];
        for(int i = 1; i < 3; i++){
            if(check != board.getBoard()[i][i]){
                check = '.';
                break;
            }
        }
        if(check != '.')
            return check;
        check = board.getBoard()[0][2];
        for(int i = 1; i < 3; i++ ){
            if(check != board.getBoard()[i][2-i]){
                check = '.';
                break;
            }
        }
        if(check != '.')
            return check;
        return '.';
    }

}
