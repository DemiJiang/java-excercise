package services;

import grid.Grid;
import grid.Coordinate;
import io.Input;
import io.Output;

import java.util.ArrayList;
import utils.*;
import validator.InputValidator;

public class GameService {
    private Input input;
    private Output output;
    private Grid grid;

    public GameService(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    private Grid buildGrid(){
        output.displayOutput("How big would you like your grid:");
        output.displayOutput("Please enter the width:");
        int gridWidth = getAndValidateInput();
        output.displayOutput("Please enter the height:");
        int gridHeight = getAndValidateInput();
        ArrayList<Coordinate> liveCellsCoordinates = getLiveCellsCoordinatesFromInput(gridWidth, gridHeight);
        return new Grid(gridWidth, gridHeight, liveCellsCoordinates);
    }

    private void gameGeneration(Grid grid, int generations){
        for(int i = 0; i < generations; i ++){
            grid = grid.getNextGenerationGrid();
            printBoard();
            Wait.pause();
        }
    }

    private int getAndValidateInput() {
        boolean validInput = false;
        String positiveIntegerAsString = "";
        while (!validInput) {
            positiveIntegerAsString = input.nextLine();
            validInput = InputValidator.isPositiveInteger(positiveIntegerAsString);
            output.displayOutput(validInput? "Thank you!": "Invalid entry! Please try again:");
        }
        return Integer.parseInt(positiveIntegerAsString);
    }


    private ArrayList<Coordinate> getLiveCellsCoordinatesFromInput(int gridWidth, int gridHeight){
        boolean validInput = false;
        String inputCoordinates = "";

        while(!validInput) {
            output.displayOutput("Please input your live cell(s) coordinates:");
            inputCoordinates = input.nextLine();
            validInput = InputValidator.isValidFormat(inputCoordinates, gridWidth, gridHeight);
            output.displayOutput(validInput? "Thank you!": "Invalid entry! Please try again:");
        }
        return InputConverter.parseInputToCoordinates(inputCoordinates);
    }

    private int getNoOfGenerations(){
        output.displayOutput("How many generations will it run: ");
        return getAndValidateInput();
    }

    public void printBoard(){
        output.displayOutput("----");
        for(int i = 0; i < grid.getHeight(); i++){
            String line = "|";
            for( int j = 0; j < grid.getWidth(); j++){
                if(grid.getCellByCooridinate(new Coordinate(i, j)).isAlive()){
                    line += "*";
                }else{
                    line += '.';
                }
            }
            line += "|";
            output.displayOutput(line);
        }
        output.displayOutput("----");


    }
    public void gameStart(){
        output.displayOutput("Welcome to Conway's Game of Life!");
        grid = buildGrid();
        printBoard();
        gameGeneration(grid, getNoOfGenerations());
    }
}
