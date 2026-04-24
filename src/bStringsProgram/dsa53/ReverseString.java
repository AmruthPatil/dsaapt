package dsa53;

import java.util.*;

public class ReverseString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char arr[] = str.toCharArray();

        int left = 0, right = arr.length - 1;

        while(left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println("Reversed string: " + new String(arr));

        sc.close();
    }
}