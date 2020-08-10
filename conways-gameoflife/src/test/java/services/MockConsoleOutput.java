package services;

import io.Output;

import java.util.ArrayList;

public class MockConsoleOutput implements Output {
    ArrayList<String> collectedOutput = new ArrayList<>();

    public ArrayList<String> returnCollectedOutput(){
        return collectedOutput;
    }

    @Override
    public void displayOutput(String string) {
        collectedOutput.add(string);
    }
}
