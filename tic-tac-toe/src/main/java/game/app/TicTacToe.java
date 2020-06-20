import IO.ConsoleInput;
import IO.ConsoleOutput;

public class TicTacToe {
    public static void main(String[] args){
        GameService game = new GameService(new ConsoleInput(), new ConsoleOutput());
        game.start();
    }
}
