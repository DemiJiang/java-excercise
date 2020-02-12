package hacerkrank;

import java.util.Scanner;

public class STDINSTDOUT {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
//        for(int i = 0; i < 3; i++){
//            int a = scan.nextInt();
//            System.out.println(a);
//        }
        while(scan.hasNextInt()){
            int a = scan.nextInt();
            System.out.println(a);
        }
    }
}
