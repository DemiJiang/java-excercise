package utils;

import grid.Coordinate;

import java.util.ArrayList;

public class InputConverter {
    public static ArrayList<Coordinate> convertInputToCoordinates(String inputCoordinatesString){
        String[] splitAtDelimiter = inputCoordinatesString.split(" ");
        ArrayList<Coordinate> parsedCoordinates = new ArrayList<>();
        for(String coordinate : splitAtDelimiter){
            parsedCoordinates.add(convertSingleCoordinate(coordinate));
        }
        return parsedCoordinates;
    }

    private static Coordinate convertSingleCoordinate(String singleInputCoordinate){
        String[] splitSingleInputCoordinate = singleInputCoordinate.split(",");
        return new Coordinate(Integer.parseInt(splitSingleInputCoordinate[0]) -1, Integer.parseInt(splitSingleInputCoordinate[1]) -1);
    }


}
