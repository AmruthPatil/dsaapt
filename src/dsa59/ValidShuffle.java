package dsa59;

import java.util.*;

public class ValidShuffle {

    public static boolean checkShuffle(String s1, String s2, String result) {

        if(result.length() != s1.length() + s2.length())
            return false;

        int i = 0, j = 0, k = 0;

        while(k < result.length()) {

            if(i < s1.length() && s1.charAt(i) == result.charAt(k)) {
                i++;
            }

            else if(j < s2.length() && s2.charAt(j) == result.charAt(k)) {
                j++;
            }

            else {
                return false;
            }

            k++;
        }

        return (i == s1.length() && j == s2.length());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input strings
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        System.out.print("Enter shuffled string: ");
        String result = sc.nextLine();

        if(checkShuffle(s1, s2, result))
            System.out.println("Valid Shuffle");
        else
            System.out.println("Not a Valid Shuffle");

        sc.close();
    }
}