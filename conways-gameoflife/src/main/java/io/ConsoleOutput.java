package io;

public class ConsoleOutput implements Output {
    @Override
    public void displayOutput(String string) {
        System.out.println(string);
    }
}
