public class CellRules {
    private static boolean isLiveCellAliveNextGen(int noOfNeighbors){
        return noOfNeighbors == 2 || noOfNeighbors ==3;
    }

    private static boolean isDeadCellAliveNextGen(int noOfNeighbors){
        return noOfNeighbors == 3;
    }

    public static boolean willCellBeAliveNextGen(Cell currentCell, Board board){
        return board.getCellByCooridinate(new Coordinates(currentCell.getxCoorinate(),currentCell.getyCoordinate())).isAlive()?
                isLiveCellAliveNextGen(board.getNumberOfNeighborsLiveCells(currentCell)):
                isDeadCellAliveNextGen(board.getNumberOfNeighborsLiveCells(currentCell));
    }

}
