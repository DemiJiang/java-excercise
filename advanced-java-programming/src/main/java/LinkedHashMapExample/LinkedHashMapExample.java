package LinkedHashMapExample;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args){
        LinkedHashMap<String, Integer> phonebook = new LinkedHashMap<>();
        phonebook.put("Kevin", 12345);
        phonebook.put("Jill", 12345);
        phonebook.put("Brenda", 12345);
        phonebook.put("Gary", 12345);
        System.out.println("Kevin's number: " + phonebook.get("Kevin"));

        System.out.println("\nList of contacts in phonebook:");
        for(Map.Entry<String, Integer> entry: phonebook.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }




    }
}
