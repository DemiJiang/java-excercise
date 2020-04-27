import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTests {
    Board board = new Board();
    Player player1 = new Player("Player1", 'X');
    Player player2 = new Player("Player2", 'O');

    @Test
    public void shouldReturnBoardWithMarkXWhenPlayer1Moved() {
        board.moveBoard(0,0, player1);
        char[][] expectedBoard = {{'X','.','.'},{'.','.','.'},{'.','.','.'}};
        assertEquals(expectedBoard, board.getBoard());

    }

    @Test
    public void shouldReturnBoardWithMarkOWhenPlayer2Moved() {
        board.moveBoard(0,2, player2);
        char[][] expectedBoard = {{'.','.','O'},{'.','.','.'},{'.','.','.'}};
        assertEquals(expectedBoard, board.getBoard());

    }
}
