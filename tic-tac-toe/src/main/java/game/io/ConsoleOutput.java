package IO;

public class ConsoleOutput implements Output {
    public ConsoleOutput() {
    }

    @Override
    public void displayOutput(String string) {
        System.out.printf("\n"+string + "\n");
    }
}
