import IO.ConsoleInput;
import IO.ConsoleOutput;
import IO.Input;
import IO.Output;

import java.util.ArrayList;

public class Game {
    private Board board;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private Player player1;
    private Player player2;
    private Winner winner;
    private Input userInput;
    private Output output;

    public Game() {
        board = new Board(3);
        players = new ArrayList<>();
        player1 = new Player("Player1", 'X');
        player2 = new Player("Player2", 'O');
        players.add(player1);
        players.add(player2);
        currentPlayer = players.get(0);
        winner = new Winner();
        userInput = new ConsoleInput();
        output = new ConsoleOutput();
    }

    public void start(){
        welcomeMessage();
        board.printBoard();
        do{
            play();
            output.displayOutput("Moved accepted");
            board.printBoard();
        }while(!isGameOver());
        System.out.println(getResult());
    }
    public void welcomeMessage() {
        output.displayOutput("Welcome to Tic Tac Toe!");
    }

    public void askCoordinates(){ output.displayOutput(currentPlayer.getName() + " enter a coord x, y to place your " + currentPlayer.getMark());}

    private void play() {
        askCoordinates();
        String input = userInput.getInput();
        if(!InputValidator.isValidFormat(input)) {
            output.displayOutput("Oh no, not a valid move! Please try again...");
                play();
            }
        move(InputValidator.inputToCoordinate(input));
    }

    public void move(Coordinates coordinates) {
        board.movePieceOnBoard(coordinates, currentPlayer.getMark());
        switchPlayer();
    }

    public Player switchPlayer() {
        return currentPlayer = currentPlayer.equals(players.get(0)) ? players.get(1) : players.get(0);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return winner.getWinner(board, players) != null || board.isBoardFull();
    }

    public String getResult() {
        if(winner.getWinner(board, players) != null) {
            switchPlayer();
            return currentPlayer.getName() + " wins!";
        } else if(board.isBoardFull()){
            return "Tie!";
        }
        return "No Winner";
    }
}
