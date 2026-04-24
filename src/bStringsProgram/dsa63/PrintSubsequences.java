package dsa63;

import java.util.*;

public class PrintSubsequences {

    public static void generate(String str, String curr, int index) {

        if(index == str.length()) {
            System.out.println(curr);
            return;
        }

        // include current character
        generate(str, curr + str.charAt(index), index + 1);

        // exclude current character
        generate(str, curr, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("All subsequences:");

        generate(str, "", 0);

        sc.close();
    }
}
