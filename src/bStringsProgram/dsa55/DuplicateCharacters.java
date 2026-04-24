package dsa55;

import java.util.*;

public class DuplicateCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch != ' ') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        System.out.println("Duplicate characters:");

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        sc.close();
    }
}