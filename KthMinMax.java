package dsaapt;

import java.util.*;

public class KthMinMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        // Check validity of k
        if(k <= 0 || k > n) {
            System.out.println("Invalid value of k");
            return;
        }

        // Sort array
        Arrays.sort(arr);

        // kth min and max
        int kthMin = arr[k-1];
        int kthMax = arr[n-k];

        // Output
        System.out.println("Kth Minimum element: " + kthMin);
        System.out.println("Kth Maximum element: " + kthMax);

        sc.close();
    }
}