import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTests {
    Board board = new Board(3);
    Player player1 = new Player("Player1", 'X');
    Player player2 = new Player("Player2", 'O');


    @Test
    public void shouldReturnBoardWithMarkXWhenPlayer1Moved() {
        Coordinates coordinates = new Coordinates(0, 0);
        board.movePieceOnBoard(coordinates, player1.getMark());
        char[][] expectedBoard = {{'X','.','.'},{'.','.','.'},{'.','.','.'}};
        assertEquals(expectedBoard, board.getBoard());

    }

    @Test
    public void shouldReturnBoardWithMarkOWhenPlayer2Moved() {
        Coordinates coordinates = new Coordinates(0, 2);
        board.movePieceOnBoard(coordinates, player2.getMark());
        char[][] expectedBoard = {{'.','.','O'},{'.','.','.'},{'.','.','.'}};
        assertEquals(expectedBoard, board.getBoard());

    }
}
