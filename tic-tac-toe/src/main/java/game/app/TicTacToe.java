package game.app;

import game.io.ConsoleInput;
import game.io.ConsoleOutput;
import game.service.GameService;

public class TicTacToe {
    public static void main(String[] args){
        GameService game = new GameService(new ConsoleInput(), new ConsoleOutput());
        game.start();
    }
}
