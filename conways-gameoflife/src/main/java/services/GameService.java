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
        ArrayList<Coordinate> liveCellsCoordinates = getLiveCellsCoordinatesFromInput();
        return new Grid(gridWidth, gridHeight, liveCellsCoordinates);
    }

    private void gameGeneration(Grid grid, int generations){
        for(int i = 0; i < generations; i ++){
            grid = grid.getNextGenerationGrid();
            output.displayOutput(grid.printGrid());
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


    private ArrayList<Coordinate> getLiveCellsCoordinatesFromInput(){
        String inputCoordinates = "";
            output.displayOutput("Please input your live cell(s) coordinates:");
            inputCoordinates = input.nextLine();
        return InputConverter.parseInputToCoordinates(inputCoordinates);
    }

    private int getNoOfGenerations(){
        output.displayOutput("How many generations will it run: ");
        return getAndValidateInput();
    }


    public void runGame(){
        output.displayOutput("Welcome to Conway's Game of Life!");
        grid = buildGrid();
        gameGeneration(grid, getNoOfGenerations());
        output.displayOutput("Thank for playing, the generation ends!");
    }
}
