package varargs;

public class Varargs {
    public static void main(String[] args){
        String items1 = "Apple";
        String items2 = "Oranges";
        String items3 = "Pears";
//        String[] shopping = {"Bread", "Milk", "Eggs", "Bananas"};
        printShoppingList(items1, items2, items3);
//        printShoppingList(shopping);
        printShoppingList("Bread", "Milk", "Eggs", "Bananas");
        printShoppingList(items1);
    }

    private static void printShoppingList(String... items){
        System.out.println("SHOPPING LIST");
        for (int i = 0; i < items.length; i++){
            System.out.println(i + 1 + ": " + items[i]);
        }
        System.out.println();
    }

//    private static void printShoppingList(String string1, String string2){
//        System.out.println("SHOPPING LIST");
//        System.out.println("1. " + string1);
//        System.out.println("2. " + string2);
//    }
//
//    private static void printShoppingList(String string1, String string2, String string3){
//        System.out.println("SHOPPING LIST");
//        System.out.println("1. " + string1);
//        System.out.println("2. " + string2);
//        System.out.println("3. " + string3);
//    }

//    private static void printShoppingList(String[] items){
//        System.out.println("SHOPPING LIST");
//        for(int i = 0; i < items.length; i++){
//            System.out.println(i + 1 + ":" + items[i]);
//        }
//        System.out.println();
//    }
}
