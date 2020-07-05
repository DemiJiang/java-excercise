public class MinesweeperArray {

    public char[][] fillNumbers(char board[][]) {
        char[][] result = new char[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++ ){
                if(isMine(i,j,board)){
                     result[i][j] = '*';
                }else{
                    result[i][j] = digitToChar(countAdjacentMines(i, j, board));
                }
            }
        }
        return result;
    }

    private int countAdjacentMines(int row, int col, char board[][]){
        int count = 0;
        for(int i = Math.max(row-1, 0); i <= Math.min(row+1, board.length-1); i++){
            for(int j = Math.max(col-1, 0); j <= Math.min(col+1, board[i].length-1); j++){
                if(isMine(i,j, board)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMine(int row, int col, char board[][]){
        return board[row][col] == '*';
    }

    private char digitToChar(int digit){
        return (char)(digit+'0');
    }

    int countAdjacentMinesOLD(int row, int col, char board[][]){
        int count = 0;
        if(isValid(row-1, col, board)){
            if(isMine(row-1, col, board)){
                count++;
            }
        }
        if(isValid(row+1, col, board)){
            if(isMine(row+1, col, board)){
                count++;
            }
        }
        if(isValid(row, col+1, board)){
            if(isMine(row, col+1, board)){
                count++;
            }
        }
        if(isValid(row, col-1, board)){
            if(isMine(row, col-1, board)){
                count++;
            }
        }
        if(isValid(row-1, col+1, board)){
            if(isMine(row-1, col+1, board)){
                count++;
            }
        }
        if(isValid(row-1, col-1, board)){
            if(isMine(row-1, col-1, board)){
                count++;
            }
        }
        if(isValid(row+1, col+1, board)){
            if(isMine(row+1, col+1, board)){
                count++;
            }
        }
        if(isValid(row+1, col-1, board)){
            if(isMine(row+1, col-1, board)){
                count++;
            }
        }
        return count;
    }

    boolean isValid(int row, int col, char board[][]){
        return (row >=0) && (row < board.length) && (col >=0) && (col < board[0].length);
    }

}
