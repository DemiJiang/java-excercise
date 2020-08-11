package grid;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    private Cell cell;

    @Test
    public void shouldReturnFalse_WhenQueryDeadCell() {
        this.cell = new Cell(false);
        assertFalse(this.cell.isAlive());
    }

    @Test
    public void shouldReturnTrue_WhenQueryLiveCell() {
        this.cell = new Cell(true);
        assertTrue(this.cell.isAlive());
    }

    @Test
    public void shouldReturnLiveCell_WhenMakingDeadCellAlive() {
        this.cell = new Cell(false);

        this.cell.makeCellAlive();

        assertTrue(this.cell.isAlive());
    }

    @Test
    public void shouldReturnTrue_WhenComparingEqualCells() {
        this.cell = new Cell(true);
        Cell secondLiveCell = new Cell(true);
        assertEquals(this.cell, secondLiveCell);
    }
}
