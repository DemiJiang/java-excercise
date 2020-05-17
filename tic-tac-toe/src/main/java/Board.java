public class Board {
    private Character[][] board;
    private int size;
    private Character filler;

    public Board(int boardSize) {
        filler = '.';
        this.size = boardSize;
        board = new Character[size][size];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                board[i][j] = filler;
            }
        }
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

    public boolean isBoardFull() {
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                if(board[i][j] == filler)
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
                    check = filler;
                    break;
                }
            }
            if(check != filler){
                return check;
            }
        }
        return filler;
    }

    public Character columnCrossed(){
        for(int i = 0; i < board.length; i++){
            Character check = board[0][i];
            for(int j = 1; j < board.length; j++){
                if(check != board[j][i]){
                    check = filler;
                    break;
                }
            }
            if(check != filler)
                return check;
        }
        return filler;
    }

    public Character diagonalCrossed(){
        Character check = board[0][0];
        for(int i = 1; i < board.length; i++){
            if(check != board[i][i]){
                check = filler;
                break;
            }
        }
        if(check != filler)
            return check;
        check = board[0][2];
        for(int i = 1; i < board.length; i++ ){
            if(check != board[i][2-i]){
                check = filler;
                break;
            }
        }
        if(check != filler)
            return check;
        return filler;
    }
}
