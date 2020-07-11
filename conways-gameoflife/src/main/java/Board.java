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

    public ArrayList<Coordinates> getCoordinatesOfNextGenerationCells(){
        ArrayList<Coordinates> coordinatesofAliveCellOnNextGeneration = new ArrayList<>();
        Cell currentCell;

        for(int x = 0; x < getWidth(); x++){
            for(int y = 0; y < getHeight(); y++){
                Coordinates currentCoordinates = new Coordinates(x, y);
                currentCell = getCellByCooridinate(currentCoordinates);
                //Why I can't use Board
                if(willCellBeAliveNextGen(currentCell)){
                    coordinatesofAliveCellOnNextGeneration.add(currentCoordinates);
                }
            }
        }
        return coordinatesofAliveCellOnNextGeneration;
    }

    public  boolean willCellBeAliveNextGen(Cell currentCell){
        return getCellByCooridinate(new Coordinates(currentCell.getxCoorinate(),currentCell.getyCoordinate())).isAlive()?
                CellRules.isLiveCellAliveNextGen(getNumberOfNeighborsLiveCells(currentCell)):
                CellRules.isDeadCellAliveNextGen(getNumberOfNeighborsLiveCells(currentCell));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board grid1 = (Board) o;
        return Arrays.deepEquals(this.board, grid1.board);
    }

    public Board getNextGenerationBoard(){
        ArrayList<Coordinates> nextBoardConfiguration = getCoordinatesOfNextGenerationCells();
        return new Board(getWidth(), getHeight(), nextBoardConfiguration);
    }

    public void printBoard(){
        System.out.println("----");
        for(int i = 0; i < getHeight(); i++){
            String line = "|";
            for( int j = 0; j < getWidth(); j++){
                if(getCellByCooridinate(new Coordinates(i, j)).isAlive()){
                    line += "*";
                }else{
                   line += '.';
                }
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("----");


    }
}
