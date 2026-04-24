package dsa54;

import java.util.*;

public class PalindromeString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int left = 0;
        int right = str.length() - 1;
        boolean isPalindrome = true;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if(isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}
