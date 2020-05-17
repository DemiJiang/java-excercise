//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class GameTests {
//    Board board = new Board(3);
//    ArrayList<Player> players = new ArrayList<>();
//    Game game;
//    Player player1 = new Player("Player1", 'X');
//    Player player2 = new Player("Player2", 'O');
//
//    @Before
//    public void before() {
//        players.add(player1);
//        players.add(player2);
//       game = new Game(board, players);
//    }
//
//    @Test
//    public void shouldReturnFalseWhenXPositionOutsideBoard(){
//        boolean result = game.isValidMove(5, 2);
//        assertFalse(result);
//    }
//
//    @Test
//    public void shouldReturnFalseWhenYPositionOutsideBoard() {
//        boolean result = game.isValidMove(2, 5);
//        assertEquals(false, result);
//    }
//
//    @Test
//    public void shouldReturnFalseWhenDuplicateMove() {
//        game.move(1, 2);
//        boolean result = game.isValidMove(1, 2);
//        assertEquals(false, result);
//    }
//
//    @Test
//    public void shouldReturnPlayer1WhenFirstTurn() {
//        Player result = game.getCurrentPlayer();
//        assertEquals(player1, result);
//    }
//
//    @Test
//    public void shouldReturnPlayer2WhenLastTurnWasPlayer1() {
//        game.move(1,1);
//        Player result = game.getCurrentPlayer();
//        assertEquals(player2, result);
//    }
//
//    @Test
//    public void shouldReturnTrueWhenBoardIsFull() {
//        game.move(0, 0);
//        game.move(0, 1);
//        game.move(0, 2);
//        game.move(1, 1);
//        game.move(1, 0);
//        game.move(2, 0);
//        game.move(1, 2);
//        game.move(2, 2);
//        game.move(2, 1);
//        board.printBoard();
//        boolean result = game.isGameOver();
//        assertTrue(result);
//    }
//
//    @Test
//    public void shouldReturnPlayer1WinTheGameWhenPlayer1IsTheWinner() {
//        game.move(1,0);// X
//        game.move(2,1);// O
//        game.move(1,1);// X
//        game.move(2,2);// O
//        game.move(1,2);// X
//        board.printBoard();
//        String result = game.getResult();
//        assertEquals("Player1 wins!", result);
//    }
//
//    @Test
//    public void shouldReturnTieWhenBoardIsFullAndNoWinner() {
//        game.move(0, 0);
//        game.move(0, 1);
//        game.move(0, 2);
//        game.move(1, 1);
//        game.move(1, 0);
//        game.move(2, 0);
//        game.move(1, 2);
//        game.move(2, 2);
//        game.move(2, 1);
//        String result = game.getResult();
//        assertEquals("Tie!", result);
//    }
//}
//
