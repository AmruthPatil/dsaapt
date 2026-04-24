package dsa68;

import java.util.*;

public class NextGreaterNumber {

    public static void findNext(String num) {

        char[] digits = num.toCharArray();
        int n = digits.length;

        int i;

        // Step 1: find first smaller digit
        for(i = n - 2; i >= 0; i--) {
            if(digits[i] < digits[i + 1])
                break;
        }

        if(i == -1) {
            System.out.println("Not Possible");
            return;
        }

        // Step 2: find smallest greater digit
        int smallest = i + 1;
        for(int j = i + 1; j < n; j++) {
            if(digits[j] > digits[i] && digits[j] <= digits[smallest]) {
                smallest = j;
            }
        }

        // Step 3: swap
        char temp = digits[i];
        digits[i] = digits[smallest];
        digits[smallest] = temp;

        // Step 4: sort remaining
        Arrays.sort(digits, i + 1, n);

        System.out.println("Next greater number = " + new String(digits));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        String num = sc.nextLine();

        findNext(num);

        sc.close();
    }
}
