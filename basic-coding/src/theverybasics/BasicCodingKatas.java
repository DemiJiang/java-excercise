package theverybasics;

public class BasicCodingKatas {
    //1.Write a program that prints ‘Hello World’ to the screen.
        //System.out.println("Hello World");

    //2.Write a program that asks the user for their name and greets them with their name.
    //3.Write a program that asks the user for their name and only greets you if you are Alice or Bob.

      /*
        System.out.println("Please enter your name:");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        if (userInput.equals("Alice") || userInput.equals("Bob")) {
            System.out.println("Hi " + userInput);
        }
     */

    //4. Write a program that asks the user for a number n and prints the sum of the numbers 1 to n

       /*
        System.out.println("Please enter a number:");
        int sum = 0;
        Scanner scN = new Scanner(System.in);
        int userNumber = scN.nextInt();
        for ( int i =1; i <= userNumber; i++) {
             sum += i;
        }
        System.out.println("Sum = " + sum);
      */

    //5. Write a program that asks the user for a number n and prints the sum of the numbers 1 to n
    // if the number is a multiple of three or five, e.g. 3, 5, 6, 9, 10, 12, 15 for n=17

        /*
        System.out.println("Please enter a number: and option for sum and 2 for product");
        Scanner scN = new Scanner(System.in);
        int userNumber = scN.nextInt();
        int option = scN.nextInt();
        if (option == 1) {
            int sum = 0;
            for (int i = 1; i <= userNumber; i++) {
                sum += i;
            }
            System.out.println("Sum = " + sum);
        } else if (option == 2) {
            int product = 1;
            for (int i = 1; i <= userNumber; i++) {
                product *= i;
            }
            System.out.println("Product = " + product);
        }
          */

    //6. Write a program that asks the user for a number n and gives them the possibility
    // to choose between computing the sum and computing the product of 1,…,n.


    //7. Write a program that prints a multiplication table for numbers up to 12.

    /*
      int num = 12;
        for (int i = 1; i <= 12; i++ ){
            System.out.printf("%d * %d = %d \n", num, i, num * i );
        }
     */
}
