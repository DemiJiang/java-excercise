import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private Cell[][] board;
    private int height;
    private int width;

    public Board(int width, int height, ArrayList<Coordinates> coordinates) {
        this.height = height;
        this.width = width;
        this.board = new Cell[width][height];
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++ ){
                if(!coordinates.isEmpty() && coordinates.contains(new Coordinates(x,y))) {
                    board[x][y] = new Cell(x,y);
                    board[x][y].makeCellAlive();
                }else{
                    board[x][y] = new Cell(x,y);
                }
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCellByCooridinate(Coordinates coordinates){
        return board[coordinates.getX()][coordinates.getY()];
    }


    public int getNumberOfNeighborsLiveCells(Cell cell){
        int count = 0;
        for(int i = Math.max(cell.getxCoorinate()-1, 0); i <= Math.min(cell.getxCoorinate()+1, getWidth()-1); i++){
            for(int j = Math.max(cell.getyCoordinate()-1, 0); j <= Math.min(cell.getyCoordinate()+1, getWidth()-1); j++){
                if(getCellByCooridinate(new Coordinates(i, j)).isAlive()){
                    count++;
                }
            }
        }
        if(getCellByCooridinate(new Coordinates(cell.getxCoorinate(),cell.getyCoordinate())).isAlive()) count--;
        return count;
    }

    public ArrayList<Coordinates> getCoordinatesOfNextGenerationCells(Board board){
        ArrayList<Coordinates> coordinatesofAliveCellOnNextGeneration = new ArrayList<>();
        Cell currentCell;

        for(int x = 0; x < board.getWidth(); x++){
            for(int y = 0; y < board.getHeight(); y++){
                Coordinates currentCoordinates = new Coordinates(x, y);
                currentCell = getCellByCooridinate(currentCoordinates);
                //why I can't use the board?
                if(CellRules.willCellBeAliveNextGen(currentCell,board)){
                    coordinatesofAliveCellOnNextGeneration.add(currentCoordinates);
                }
            }
        }
        return coordinatesofAliveCellOnNextGeneration;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return Arrays.deepEquals(this.board, board1.board);
    }

}
