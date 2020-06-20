package game.model;

public class Board {
    private Character[][] board;
    private int size;
    private static final Character FILLER = '.';

    //length wide
    public Board(int boardSize) {
        this.size = boardSize;
        board = new Character[size][size];
        initializeBoard(FILLER);
    }

//    public Board(int lengthSize, int wideSize, Character FILLER) {
//        this.size = boardSize;
//        board = new Character[lengthSize][wideSize];
//        initializeBoard(FILLER);
//    }

    private void initializeBoard(Character FILLER){
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                board[i][j] = FILLER;
            }
        }
    }

    //How to make others to use the board
    public static Board getDefaultBoard(){
        return new Board(3);
    }


    public void movePieceOnBoard(Coordinates coordinates, Character piece){
        board[coordinates.getX()][coordinates.getY()] = piece;
    }

    public void printBoard(){
        System.out.println("Here's the currect board");
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Character[][] getBoard() {
        return board;
    }

    public boolean isPositionAvailable(Coordinates coordinates) {
        return board[coordinates.getX()][coordinates.getY()] == FILLER;

    }

    public boolean noMoveLeft() {
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                if(board[i][j] == FILLER)
                    return false;
            }
        }
        return true;
    }

    public Character rowCrossed(){
        for(int i = 0; i < board.length; i++){
            Character check = board[i][0];
            for(int j = 1; j < board.length; j++){
                if(check != board[i][j]){
                    check = FILLER;
                    break;
                }
            }
            if(check != FILLER){
                return check;
            }
        }
        return FILLER;
    }

    public Character columnCrossed(){
        for(int i = 0; i < board.length; i++){
            Character check = board[0][i];
            for(int j = 1; j < board.length; j++){
                if(check != board[j][i]){
                    check = FILLER;
                    break;
                }
            }
            if(check != FILLER)
                return check;
        }
        return FILLER;
    }

    public Character diagonalCrossed(){
        Character check = board[0][0];
        for(int i = 1; i < board.length; i++){
            if(check != board[i][i]){
                check = FILLER;
                break;
            }
        }
        if(check != FILLER)
            return check;
        check = board[0][2];
        for(int i = 1; i < board.length; i++ ){
            if(check != board[i][2-i]){
                check = FILLER;
                break;
            }
        }
        if(check != FILLER)
            return check;
        return FILLER;
    }
}
