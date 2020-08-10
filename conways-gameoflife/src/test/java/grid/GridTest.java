package grid;

import grid.Grid;
import grid.Cell;
import grid.Coordinate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GridTest {
    private Grid grid;

    @Before
    public void setUp(){
        grid = new Grid(5, 5, new ArrayList<>(1));
    }

    @After
    public void tearDown(){ grid = null;}

    private boolean isBoardEmpty(Grid grid){
        for(int x = 0; x < grid.getWidth(); x++){
            for(int y = 0; y < grid.getHeight(); y++){
                if(grid.getCellByCooridinate(new Coordinate(x,y)).isAlive()){
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    public void shouldReturnEmptyGrid_WhenInitialised() {
        boolean actual = isBoardEmpty(grid);
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldNotReturnEmptyGrid_WhenContainsAliveCell() {
        Grid grid = new Grid(5, 5,
                new ArrayList<>(Arrays.asList(new Coordinate(1,1))));
        boolean actual = isBoardEmpty(grid);
        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturn1ForLiveCell_WhenNoOfNeigbournLiveCellIs1() {
        Grid grid = new Grid(3, 3,
                new ArrayList<>(Arrays.asList(new Coordinate(1, 1), new Coordinate(2, 2))));
        assertEquals(1, grid.getNumberOfNeighborsLiveCells(new Cell(1,1)));
    }

    @Test
    public void shouldReturn3ForDeadCell_WhenNoOfNeigbournLiveCellIs3() {
        Grid grid = new Grid(3, 3,
                new ArrayList<>(Arrays.asList(new Coordinate(0, 1), new Coordinate(2,1), new Coordinate(2, 2))));
        assertEquals(3, grid.getNumberOfNeighborsLiveCells(new Cell(1,1)));
    }

    @Test
    public void shouldReturnArrayOfNextGenerationCoordinates_WhenGridhas3LiveCells() {
        Grid grid = new Grid(5, 5,
        new ArrayList<>(Arrays.asList(new Coordinate(2, 1), new Coordinate(2, 2), new Coordinate(2,3))));

        ArrayList<Coordinate> expectedCoordinates = new ArrayList<>(
                Arrays.asList(new Coordinate(1, 2), new Coordinate(2, 2), new Coordinate(3,2))
        );
        assertEquals(expectedCoordinates, grid.getCoordinatesOfNextGenerationCells());
    }

    @Test
    public void shouldReturnNewGridWithNextGenerationCells() {
        grid = new Grid(5, 5, new ArrayList<>(Arrays.asList(
                new Coordinate(3,1), new Coordinate(3,2), new Coordinate(3,3)
        )));
        Grid expectedNextGenGrid = new Grid(5, 5, new ArrayList<>(Arrays.asList(
                new Coordinate(2,2), new Coordinate(3,2), new Coordinate(4,2)
        )));

        Grid actual = grid.getNextGenerationGrid();
        assertEquals(expectedNextGenGrid, actual);


    }
}
