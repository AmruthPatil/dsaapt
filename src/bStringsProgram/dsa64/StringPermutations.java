package dsa64;

import java.util.*;

public class StringPermutations {

    public static void permute(char[] arr, int l, int r) {

        if(l == r) {
            System.out.println(String.valueOf(arr));
            return;
        }

        for(int i = l; i <= r; i++) {
            swap(arr, l, i);
            permute(arr, l + 1, r);
            swap(arr, l, i); // backtrack
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("All permutations:");

        permute(str.toCharArray(), 0, str.length() - 1);

        sc.close();
    }
}
