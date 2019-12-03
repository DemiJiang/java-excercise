import java.util.Scanner;

public class Main {
    public static void main(String[] args){
       // One
        System.out.println("Hello World");

        //Two and Three
        System.out.println("Please enter your name:");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        if (userInput.equals("Alice") || userInput.equals("Bob")) {
            System.out.println("Hi " + userInput);
        }

        //Four

    }
}
