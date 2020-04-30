public class Board {
    private char[][] board;
    private int size;

    public Board(int boardSize) {
        this.size = boardSize;
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                board[i][j] = '.';
            }
        }
    }

    public void moveBoard(int xPosition, int yPosition, Player player){
        board[xPosition][yPosition] = player.getMark();
    }

    public void printBoard(){
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isBoardFull() {
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                if(board[i][j] == '.')
                    return false;
            }
        }
        return true;
    }
}
