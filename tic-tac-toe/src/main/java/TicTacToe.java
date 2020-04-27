import java.util.ArrayList;

public class TicTacToe {
    public static void main(String[] args){
        Board board = new Board();
        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');
        players.add(player1);
        players.add(player2);
        Game game = new Game(board, players);
        game.start();
    }
}
