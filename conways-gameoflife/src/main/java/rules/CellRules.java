package rules;

import grid.Grid;
import grid.Cell;
import grid.Coordinate;

public class CellRules {
    static boolean isLiveCellAliveNextGen(int noOfLiveNeighbors){
        return noOfLiveNeighbors == 2 || noOfLiveNeighbors ==3;
    }

    static boolean isDeadCellAliveNextGen(int noOfNeighbors){
        return noOfNeighbors == 3;
    }

    public static boolean willCellBeAliveNextGen(Cell currentCell, Grid grid){
        return grid.getCellByCooridinate(new Coordinate(currentCell.getxCoorinate(),currentCell.getyCoordinate())).isAlive()?
                isLiveCellAliveNextGen(grid.countNumberOfNeighborsLiveCells(currentCell)):
                isDeadCellAliveNextGen(grid.countNumberOfNeighborsLiveCells(currentCell));
    }


}
