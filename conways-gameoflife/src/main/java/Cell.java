public class Cell {
    private boolean isAlive;
    private int xCoorinate;
    private int yCoordinate;

    public Cell(int xCoorinate, int yCoordinate) {
        this.xCoorinate = xCoorinate;
        this.yCoordinate = yCoordinate;
        this.isAlive=false;
    }

//        @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cell cell = (Cell) o;
//        return isAlive() == cell.isAlive();
//    }

    public boolean isAlive() {
        return isAlive;
    }

    public void makeCellAlive(){
        this.isAlive = true;
    }

    public int getxCoorinate() {
        return xCoorinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
}