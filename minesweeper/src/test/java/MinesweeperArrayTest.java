import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class MinesweeperArrayTest {

    @Test
    public void returnBombIfCellIsBomb() {
        MinesweeperArray minesweeperArray = new MinesweeperArray();
        char[][] input = {{'*'}};
        char[][] expectedOutput = {{'*'}};
        assertEquals(expectedOutput, minesweeperArray.fillNumbers(input));
    }

    @Test
    public void return0IfNoBombsAround() {
        MinesweeperArray minesweeperArray = new MinesweeperArray();
        char[][] input = {{'.'}};
        char[][] expectedOutput = {{'0'}};
        assertEquals(expectedOutput, minesweeperArray.fillNumbers(input));
    }

    @Test
    public void return1IfThereIsABomb() {
        MinesweeperArray minesweeperArray = new MinesweeperArray();
        char[][] input = {{'*', '1'}};
        char[][] expectedOutput = {{'*', '1'}};
        assertEquals(expectedOutput, minesweeperArray.fillNumbers(input));
    }

    @Test
    public void fillNumbersWithSurroundedBombs() {
        MinesweeperArray minesweeperArray = new MinesweeperArray();
        char[][] input = {{'*','*','*'}, {'*', '.','*'}, {'*', '*', '*'}};
        char[][] expectedOutput = {{'*','*','*'}, {'*', '8','*'}, {'*', '*', '*'}};
        assertEquals(expectedOutput, minesweeperArray.fillNumbers(input));
    }

    @Test
    public void fillNumbersWithASimpleBoard() {
        MinesweeperArray minesweeperArray = new MinesweeperArray();
        char[][] input = {{'*','.','.','.'},{'.','.','.','.'},{'.','*','.','.'},{'.','.','.','.'}};
        char[][] expectedOutput = {{'*','1','0','0'},{'2','2','1','0'},{'1','*','1','0'},{'1','1','1','0'}};
        assertEquals(expectedOutput, minesweeperArray.fillNumbers(input));
    }
}
