import IO.Input;
import IO.Output;

import java.util.ArrayList;

public class GameService {
    private Board board;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private Player player1;
    private Player player2;
    private Input userInput;
    private Output output;

    public GameService(Input userInput, Output output) {
        board = new Board(3);
        players = new ArrayList<>();
        player1 = new Player("Player1", 'X');
        player2 = new Player("Player2", 'O');
        players.add(player1);
        players.add(player2);
        currentPlayer = players.get(0);
        this.userInput = userInput;
        this.output = output;
    }

    public void start(){
        welcomeMessage();
        board.printBoard();
        do{
            boolean successfulMove = false;
            do {
                successfulMove = moveAccepted();
            }while(!successfulMove);
            board.printBoard();
            switchPlayer();
        }while(!isGameOver());
        output.displayOutput(getResult());
    }

    public boolean moveAccepted(){
        askCoordinates();
        String userResponse = userInput.getInput();
        Coordinates playerCoordinates = InputValidator.inputToCoordinate(userResponse);
        if(InputValidator.isQuitKeyword(userResponse)){
            System.exit(0);
        }
        if(InputValidator.isValidFormat(userResponse) && InputValidator.isValidInputWithBoardRange(userResponse, board.getBoard().length)){
            if(isPositionAvailable(playerCoordinates)){
                makeMove(playerCoordinates);
                output.displayOutput("Moved accepted");
                return true;
            }else{
                output.displayOutput("Oh no, a piece is already taken at this place! Please try again...");
                return false;
            }
        }
        output.displayOutput("Oh no, not a valid move! Please try again..."); // how do I handle exception?
        return false;
    }

    public boolean isPositionAvailable(Coordinates coordinates) {
        return board.getBoard()[coordinates.getX()][coordinates.getY()] == '.';

    }

    public void makeMove(Coordinates coordinates) {
        board.movePieceOnBoard(coordinates, currentPlayer.getMark());
    }

    public void welcomeMessage() {
        output.displayOutput("Welcome to Tic Tac Toe!");
    }

    public void askCoordinates(){ output.displayOutput(currentPlayer.getName() + " enter a coord x, y to place your " + currentPlayer.getMark() + " or enter 'q' to give up: ");}


    public Player switchPlayer() {
        return currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public boolean isGameOver() {
        return getWinner(board, players) != null || board.isBoardFull();
    }

    public Player getWinner(Board board, ArrayList<Player> players) {
        char rowSymbol = board.rowCrossed();
        char colSymbol = board.columnCrossed();
        char diagonalSymbol = board.diagonalCrossed();
        for(Player player : players){
            if(player.getMark() == rowSymbol) return player;
            if(player.getMark() == colSymbol) return player;
            if(player.getMark() == diagonalSymbol) return player;
        }
        return null;
    }

    public String getResult() {
        if(getWinner(board, players) != null) {
            switchPlayer();
            return currentPlayer.getName() + " wins!";
        } else if(board.isBoardFull()){
            return "Tie!";
        }
        return "No Winner";
    }


}
