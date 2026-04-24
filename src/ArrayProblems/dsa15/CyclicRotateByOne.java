package dsa15;

import java.util.*;

public class CyclicRotateByOne {
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

        // Store last element
        int last = arr[n - 1];

        // Shift elements right
        for(int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        // Place last element at first position
        arr[0] = last;

        // Output
        System.out.println("Array after cyclic rotation by one:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}