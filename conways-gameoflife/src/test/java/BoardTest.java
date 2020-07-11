import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private Board board;

    @Before
    public void setUp(){
        board = new Board(5, 5, new ArrayList<>(1));
    }

    @After
    public void tearDown(){ board = null;}

    private boolean isBoardEmpty(Board board){
        for(int x = 0; x < board.getWidth(); x++){
            for(int y = 0; y < board.getHeight(); y++){
                if(board.getCellByCooridinate(new Coordinates(x,y)).isAlive()){
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    public void shouldReturnEmptyGrid_WhenInitialised() {
        boolean actual = isBoardEmpty(board);
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldNotReturnEmptyGrid_WhenContainsAliveCell() {
        Board board = new Board(5, 5,
                new ArrayList<>(Arrays.asList(new Coordinates(1,1))));
        boolean actual = isBoardEmpty(board);
        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturn1ForLiveCell_WhenNoOfNeigbournLiveCellIs1() {
        Board board = new Board(3, 3,
                new ArrayList<>(Arrays.asList(new Coordinates(1, 1), new Coordinates(2, 2))));
        assertEquals(1, board.getNumberOfNeighborsLiveCells(new Cell(1,1)));
    }

    @Test
    public void shouldReturn3ForDeadCell_WhenNoOfNeigbournLiveCellIs3() {
        Board board = new Board(3, 3,
                new ArrayList<>(Arrays.asList(new Coordinates(0, 1), new Coordinates(2,1), new Coordinates(2, 2))));
        assertEquals(3, board.getNumberOfNeighborsLiveCells(new Cell(1,1)));
    }

    @Test
    public void shouldReturnArrayOfNextGenerationCoordinates_WhenBoardhas3LiveCells() {
        Board board = new Board(5, 5,
        new ArrayList<>(Arrays.asList(new Coordinates(2, 1), new Coordinates(2, 2), new Coordinates(2,3))));

        ArrayList<Coordinates> expectedCoordinates = new ArrayList<>(
                Arrays.asList(new Coordinates(1, 2), new Coordinates(2, 2), new Coordinates(3,2))
        );
        assertEquals(expectedCoordinates, board.getCoordinatesOfNextGenerationCells());
    }

    @Test
    public void shouldReturnNewBoardWithNextGenerationCells() {
        board = new Board(5, 5, new ArrayList<>(Arrays.asList(
                new Coordinates(3,1), new Coordinates(3,2), new Coordinates(3,3)
        )));
        Board expectedNextGenBoard = new Board(5, 5, new ArrayList<>(Arrays.asList(
                new Coordinates(2,2), new Coordinates(3,2), new Coordinates(4,2)
        )));

        Board actual = board.getNextGenerationBoard();
        assertEquals(expectedNextGenBoard, actual);


    }
}
