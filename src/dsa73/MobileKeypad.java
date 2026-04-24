package dsa73;

import java.util.*;

public class MobileKeypad {

    public static String printSequence(String str) {

        String[] keypad = {
            "2", "22", "222",
            "3", "33", "333",
            "4", "44", "444",
            "5", "55", "555",
            "6", "66", "666",
            "7", "77", "777", "7777",
            "8", "88", "888",
            "9", "99", "999", "9999"
        };

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if(ch == ' ') {
                output.append("0");
            }
            else {
                output.append(keypad[ch - 'A']);
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input sentence
        System.out.print("Enter a sentence (UPPERCASE): ");
        String str = sc.nextLine();

        System.out.println("Keypad sequence = " + printSequence(str));

        sc.close();
    }
}
