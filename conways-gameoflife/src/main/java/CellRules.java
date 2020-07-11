public class CellRules {
    static boolean isLiveCellAliveNextGen(int noOfNeighbors){
        return noOfNeighbors == 2 || noOfNeighbors ==3;
    }
    static boolean isDeadCellAliveNextGen(int noOfNeighbors){
        return noOfNeighbors == 3;
    }
}
