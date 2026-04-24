package dsa11;

import java.util.Scanner;

public class MaxMinArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input for array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // User input for array elements
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Assume first element as max and min
        int max = arr[0];
        int min = arr[0];

        // Traverse array
        for(int i = 1; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        // Output
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);

        sc.close();
    }
}