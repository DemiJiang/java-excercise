package grid;

import rules.CellRules;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private Cell[][] grid;
    private int height;
    private int width;

    public Grid(int width, int height, ArrayList<Coordinate> coordinates) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[width][height];
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++ ){
                if(!coordinates.isEmpty() && coordinates.contains(new Coordinate(x,y))) {
                    grid[x][y] = new Cell(x,y);
                    grid[x][y].makeCellAlive();
                }else{
                    grid[x][y] = new Cell(x,y);
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

    public Cell getCellByCooridinate(Coordinate coordinate){
        return grid[coordinate.getX()][coordinate.getY()];
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid1 = (Grid) o;
        return Arrays.deepEquals(this.grid, grid1.grid);
    }


    public String printGrid(){
        StringBuilder board = new StringBuilder();
        for(int i = 0; i < getHeight(); i++){
            for(int j = 0; j < getWidth(); j++){
                if(getCellByCooridinate(new Coordinate(i, j)).isAlive()){
                    board.append("*");
                }else{
                    board.append(".");
                }
            }
            board.append("\n");
        }
        return board.toString();
    }

    public int countNumberOfNeighborsLiveCells(Cell cell){
        int count = 0;
        for(int i = Math.max(cell.getxCoorinate()-1, 0); i <= Math.min(cell.getxCoorinate()+1, getWidth()-1); i++){
            for(int j = Math.max(cell.getyCoordinate()-1, 0); j <= Math.min(cell.getyCoordinate()+1, getWidth()-1); j++){
                if(getCellByCooridinate(new Coordinate(i, j)).isAlive()){
                    count++;
                }
            }
        }
        if(getCellByCooridinate(new Coordinate(cell.getxCoorinate(),cell.getyCoordinate())).isAlive()) count--;
        return count;
    }

    public ArrayList<Coordinate> getCoordinatesOfNextGenerationCells(){
        ArrayList<Coordinate> coordinatesofAliveCellOnNextGeneration = new ArrayList<>();
        Cell currentCell;

        for(int x = 0; x < getWidth(); x++){
            for(int y = 0; y < getHeight(); y++){
                Coordinate currentCoordinate = new Coordinate(x, y);
                currentCell = getCellByCooridinate(currentCoordinate);
                if(CellRules.willCellBeAliveNextGen(currentCell, this)){
                    coordinatesofAliveCellOnNextGeneration.add(currentCoordinate);
                }
            }
        }
        return coordinatesofAliveCellOnNextGeneration;
    }

    public Grid getNextGenerationGrid(){
        ArrayList<Coordinate> nextBoardConfiguration = getCoordinatesOfNextGenerationCells();
        return new Grid(getWidth(), getHeight(), nextBoardConfiguration);
    }

}
