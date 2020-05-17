import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WinnerTests {
    Board board = new Board(3);
    ArrayList<Player> players = new ArrayList<>();
    GameService game;
    Player player1 = new Player("Player1", 'X');
    Player player2 = new Player("Player2", 'O');
    Winner winner = new Winner();

    @Before
    public void before() {
        players.add(player1);
        players.add(player2);
        game = new GameService(board, players);
    }

    @Test
    public void shouldReturnPlayer1WhenWholeRowCrossedWithX(){
        game.move(1,0);
        game.move(2,1);
        game.move(1,1);
        game.move(2,2);
        game.move(1,2);
        board.printBoard();
        Player result = winner.getWinner(board, players);
        assertEquals(player1, result);
    }

    @Test
    public void shouldReturnPlayer2WhenWholeColumnCrossedWithO() {
        game.move(0, 0);
        game.move(0, 1);
        game.move(0, 2);
        game.move(1, 1);
        game.move(1, 0);
        game.move(2, 1);
        board.printBoard();
        Player result = winner.getWinner(board,players);
        assertEquals(player2, result);
    }

    @Test
    public void shouldReturnPlayer1WhenDiagonalCrossedWithXFromTopToBottom() {
        game.move(0, 0);
        game.move(1, 0);
        game.move(1, 1);
        game.move(2, 1);
        game.move(2, 2);
        board.printBoard();
        Player result = winner.getWinner(board,players);
        assertEquals(player1, result);
    }

    @Test
    public void shouldReturnPlayer2WhenDiagonalCrossedWithOFromBottomToTop() {
        game.move(0, 0);
        game.move(0, 2);
        game.move(1, 0);
        game.move(1, 1);
        game.move(1, 2);
        game.move(2, 0);
        board.printBoard();
        Player result = winner.getWinner(board, players);
        assertEquals(player2, result);
    }


}
