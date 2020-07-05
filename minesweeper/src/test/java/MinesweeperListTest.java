import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MinesweeperListTest {
    @Test
    public void returnBombIfCellIsBomb() {
        MinesweeperList minesweeperList = new MinesweeperList();
        List<List<Character>> input = new ArrayList<>();
        input.add(Arrays.asList('*'));
        List<List<Character>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Arrays.asList('*'));
        assertEquals(expectedOutput, minesweeperList.fillNumbers(input));
    }

    @Test
    public void return0whenNoBombAround() {
        MinesweeperList minesweeperList = new MinesweeperList();
        List<List<Character>> input = new ArrayList<>();
        input.add(Arrays.asList('.'));
        List<List<Character>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Arrays.asList('0'));
        assertEquals(expectedOutput, minesweeperList.fillNumbers(input));
    }

    @Test
    public void return1IfThereIsABomb() {
        MinesweeperList minesweeperList = new MinesweeperList();
        List<List<Character>> input = new ArrayList<>();
        input.add(Arrays.asList('*', '.'));
        List<List<Character>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Arrays.asList('*', '1'));
        assertEquals(expectedOutput, minesweeperList.fillNumbers(input));
    }

    @Test
    public void fillNumbersWithBombSurround() {
        MinesweeperList minesweeperList = new MinesweeperList();
        List<String> input = new ArrayList<>(Arrays.asList("***", "*.*", "***"));
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("***", "*8*", "***"));
        assertEquals(convertToBoard(expectedOutput), minesweeperList.fillNumbers(convertToBoard(input)));

    }

    private List<List<Character>> convertToBoard(List<String> board){
        List<List<Character>> result = board.stream().map(e -> convertStringToCharList(e)).collect(Collectors.toList());
        return result;
    }

    public static List<Character> convertStringToCharList(String str) {
        List<Character> chars = str.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        return chars;
    }
}
