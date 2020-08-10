package rules;

import grid.Grid;
import grid.Cell;
import grid.Coordinate;
import org.junit.Test;
import rules.CellRules;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RulesTest {

    @Test
    public void shouldReturnDeadCell_WhenLiveCellSurrounded1LiveCell() {
        Grid grid = new Grid(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinate(1, 1), new Coordinate(2,2))));
        assertFalse(CellRules.willCellBeAliveNextGen(new Cell(1,1), grid));
    }

    @Test
    public void shouldReturnLiveCell_WhenLiveCellSurrounded2LiveCells() {
        Grid grid = new Grid(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinate(1, 1), new Coordinate(2,2), new Coordinate(0,1))));
        assertTrue(CellRules.willCellBeAliveNextGen(new Cell(1,1), grid));
    }

    @Test
    public void shouldReturnLiveCell_WhenLiveCellSurrounded3LiveCells() {
        Grid grid = new Grid(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinate(1, 1), new Coordinate(2,2), new Coordinate(0,0), new Coordinate(1,2))));
        assertTrue(CellRules.willCellBeAliveNextGen(new Cell(1,1), grid));
    }

    @Test
    public void shouldReturnDeadCell_WhenLiveCellSurrounded4LiveCell() {
        Grid grid = new Grid(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinate(0,1), new Coordinate(1, 1), new Coordinate(2,2),
                        new Coordinate(0,0), new Coordinate(2,1))));
        assertFalse(CellRules.willCellBeAliveNextGen(new Cell(1,1), grid));
    }

    @Test
    public void shouldReturnLiveCell_WhenDeadCellSurrounded3LiveCells() {
        Grid grid = new Grid(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinate(1, 0), new Coordinate(2,2), new Coordinate(1,2))));
        assertTrue(CellRules.willCellBeAliveNextGen(new Cell(1,1), grid));
    }

}
