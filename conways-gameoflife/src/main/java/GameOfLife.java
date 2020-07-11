import java.util.ArrayList;

public class GameOfLife {
    int height;
    int width;
    int[][] grid;

    public GameOfLife(int width, int height) {
        this.height = width;
        this.width = height;
        this.grid = new int[width][height];
    }



    public void printBoard(){
        System.out.println("----");
        for (int y = 0; y < height; y++) {
            String line = "|";
            for (int x = 0; x < width; x++) {
                if (this.grid[x][y] == 0) {
                    line += ".";
                } else {
                    line += "*";
                }
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("----\n");
        }

        public void setAlive(int x, int y){
        this.grid[x][y] = 1;
        }

    private int countAdjacentMines(int row, int col, int board[][]){
        int count = 0;
        for(int i = Math.max(row-1, 0); i <= Math.min(row+1, board.length-1); i++){
            for(int j = Math.max(col-1, 0); j <= Math.min(col+1, board[i].length-1); j++){
                if(isAlive(i,j, board)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isAlive(int row, int col, int board[][]){
        return board[row][col] == 1;
    }

    public void setup(){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int aliveN = countAdjacentMines(x,y, grid);
                if(this.grid[x][y]==1){
                    if(aliveN < 2){
                        this.grid[x][y] = 0;
                    } else if(aliveN == 2 || aliveN == 3){
                        this.grid[x][y] = 1;
                    } else if(aliveN > 3){
                        this.grid[x][y] = 0;
                    }
                }else {
                    if(aliveN == 3){
                        this.grid[x][y] = 1;
                    }
                }
            }
        }

    }

    public static void main(String[] args){
        GameOfLife gameOfLife = new GameOfLife(5,5);

        gameOfLife.setAlive(2,2);
        gameOfLife.setAlive(3,2);
        gameOfLife.setAlive(4,2);

        gameOfLife.printBoard();

        gameOfLife.setup();

        gameOfLife.printBoard();

        System.out.println(new ArrayList<>(1));


    }

}
