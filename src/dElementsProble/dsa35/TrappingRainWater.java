package dsa35;

import java.util.*;

public class TrappingRainWater {

    public static int trapWater(int arr[], int n) {

        if(n <= 2)
            return 0;

        int left[] = new int[n];
        int right[] = new int[n];

        // Fill left max array
        left[0] = arr[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        // Fill right max array
        right[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        // Calculate trapped water
        int water = 0;
        for(int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of bars: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input heights
        System.out.println("Enter heights of bars:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = trapWater(arr, n);

        System.out.println("Total trapped rain water = " + result);

        sc.close();
    }
}