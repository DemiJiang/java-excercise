import io.ConsoleInput;
import io.ConsoleOutput;
import services.GameService;

public class Main {
    public static void main(String[] args){
        GameService gameService = new GameService(new ConsoleInput(), new ConsoleOutput());
        gameService.runGame();
    }
}
