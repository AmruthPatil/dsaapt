package dsa40;

import java.util.*;

public class MinOperationsPalindrome {

    public static int minOperations(int arr[], int n) {

        int i = 0, j = n - 1;
        int count = 0;

        while(i < j) {

            if(arr[i] == arr[j]) {
                i++;
                j--;
            }

            else if(arr[i] < arr[j]) {
                arr[i + 1] = arr[i] + arr[i + 1];
                i++;
                count++;
            }

            else {
                arr[j - 1] = arr[j] + arr[j - 1];
                j--;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = minOperations(arr, n);

        System.out.println("Minimum operations required = " + result);

        sc.close();
    }
}