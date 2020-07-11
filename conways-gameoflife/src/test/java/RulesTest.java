import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RulesTest {

    @Test
    public void shouldReturnDeadCell_WhenLiveCellSurrounded1LiveCell() {
        Board board = new Board(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinates(1, 1), new Coordinates(2,2))));
        assertFalse(CellRules.willCellBeAliveNextGen(new Cell(1,1), board));
    }

    @Test
    public void shouldReturnLiveCell_WhenLiveCellSurrounded2LiveCells() {
        Board board = new Board(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinates(1, 1), new Coordinates(2,2), new Coordinates(0,1))));
        assertTrue(CellRules.willCellBeAliveNextGen(new Cell(1,1), board));
    }

    @Test
    public void shouldReturnLiveCell_WhenLiveCellSurrounded3LiveCells() {
        Board board = new Board(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinates(1, 1), new Coordinates(2,2), new Coordinates(0,0), new Coordinates(1,2))));
        assertTrue(CellRules.willCellBeAliveNextGen(new Cell(1,1), board));
    }

    @Test
    public void shouldReturnDeadCell_WhenLiveCellSurrounded4LiveCell() {
        Board board = new Board(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinates(0,1), new Coordinates(1, 1), new Coordinates(2,2),
                        new Coordinates(0,0), new Coordinates(2,1))));
        assertFalse(CellRules.willCellBeAliveNextGen(new Cell(1,1), board));
    }

    @Test
    public void shouldReturnLiveCell_WhenDeadCellSurrounded3LiveCells() {
        Board board = new Board(3, 3, new ArrayList<>(Arrays.asList
                (new Coordinates(1, 0), new Coordinates(2,2), new Coordinates(1,2))));
        assertTrue(CellRules.willCellBeAliveNextGen(new Cell(1,1), board));
    }
}
