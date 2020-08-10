package services;

import io.Input;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameServiceTest {
    private GameService game;
    private Input input;
    private MockConsoleOutput output;
    private ArrayList<String> mockInput;

    @Before
    public void setUp() {
        mockInput = new ArrayList<>();
        mockInput.add("5");
        mockInput.add("5");
        mockInput.add("2,1 2,2 2,3");
        mockInput.add("2");

        input = new MockConsoleInput(mockInput);
        output = new MockConsoleOutput();
        game = new GameService(input, output);
    }

    @Test
    public void startGameE2Etest() {
        ArrayList<String> expectedMessage = new ArrayList<>(Arrays.asList(
                "Welcome to Conway's Game of Life!",
                "How big would you like your grid:",
                "Please enter the width:",
                "Thank you!",
                "Please enter the height:",
                "Thank you!",
                "Please input your live cell(s) coordinates:",
                "How many generations will it run: ",
                "Thank you!",
                ".*...\n" + ".*...\n" + ".*...\n" + ".....\n" + ".....\n" ,
                ".....\n" + "***..\n" + ".....\n" + ".....\n" + ".....\n" ,
                "Thank for playing, the generation ends!"
        ));
        game.runGame();
        assertEquals(expectedMessage.toString(), output.returnCollectedOutput().toString());
    }

    @Test
    public void runGameWithValidation() {
        mockInput.add(3, "h");
        ArrayList<String> expectedMessage = new ArrayList<>(Arrays.asList(
                "Welcome to Conway's Game of Life!",
                "How big would you like your grid:",
                "Please enter the width:",
                "Thank you!",
                "Please enter the height:",
                "Thank you!",
                "Please input your live cell(s) coordinates:",
                "How many generations will it run: ",
                "Invalid entry! Please try again:",
                "Thank you!",
                ".*...\n" + ".*...\n" + ".*...\n" + ".....\n" + ".....\n" ,
                ".....\n" + "***..\n" + ".....\n" + ".....\n" + ".....\n" ,
                "Thank for playing, the generation ends!"
        ));
        game.runGame();
        System.out.println(mockInput);
        assertEquals(expectedMessage.toString(), output.returnCollectedOutput().toString());
    }
}
