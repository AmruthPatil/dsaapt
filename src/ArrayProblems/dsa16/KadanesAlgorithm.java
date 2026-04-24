package dsa16;

import java.util.*;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Kadane's Algorithm
        int maxSum = arr[0];
        int currentSum = arr[0];

        for(int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        // Output
        System.out.println("Maximum Subarray Sum: " + maxSum);

        sc.close();
    }
}
