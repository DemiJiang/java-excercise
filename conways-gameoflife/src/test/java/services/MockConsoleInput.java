package services;

import io.Input;

import java.util.ArrayList;

public class MockConsoleInput implements Input {

    private int counter = 0;
    private ArrayList<String> mockedInputData;

    public MockConsoleInput(ArrayList<String> givenData) {
        this.mockedInputData = givenData;
    }

    @Override
    public String nextLine() {
        String input = mockedInputData.get(counter);
        counter++;
        return input;
    }
}
