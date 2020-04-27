import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private Winner winner;

    public Game(Board board, ArrayList<Player> players) {
        this.board = board;
        this.players = players;
        currentPlayer = players.get(0);
        winner = new Winner();
    }

    public void start(){
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Here's the currect board");
        board.printBoard();
        do{
            play();
            System.out.println("Moved accepted, here's the current board:");
            board.printBoard();
        }while(!isGameOver());
        System.out.println(getResult());
    }

    private void play() {
        System.out.println(currentPlayer.getName() + " enter a coord x, y to place your " + currentPlayer.getMark());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] moves = input.split(",");
        if(!isValidMove(Integer.parseInt(moves[0]) - 1, Integer.parseInt(moves[1]) - 1)) {
                System.out.println("Oh no, not a valid move! Please try again...");
                play();
            }
        move(Integer.parseInt(moves[0]) - 1, Integer.parseInt(moves[1]) - 1);
        //how to handle exception? or error handling?

//        try {
//            String[] moves = input.split(",");
//            if(!isValidMove(Integer.parseInt(moves[0]) - 1, Integer.parseInt(moves[1]) - 1)) {
//                System.out.println("Oh no, not a valid move! Please try again...");
//                play();
//            }
//            move(Integer.parseInt(moves[0]) - 1, Integer.parseInt(moves[1]) - 1);
//        } catch (Exception e){
//            play();
//        }
    }

    public boolean isValidMove(int xPosition, int yPosition) {
        if(xPosition < 0 || xPosition > 3 || yPosition < 0 || yPosition > 3)
            return false;
        if(board.getBoard()[xPosition][yPosition] != '.')
            return false;
        return true;
    }

    public void move(int xPosition, int yPosition) {
        board.moveBoard(xPosition, yPosition, currentPlayer);
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
