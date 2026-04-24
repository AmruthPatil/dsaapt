package dsa17;

import java.util.*;

public class MinimizeHeightDifference {
    public static int getMinDiff(int arr[], int n, int k) {

        // Sort array
        Arrays.sort(arr);

        // Initial difference
        int ans = arr[n-1] - arr[0];

        int small = arr[0] + k;
        int big = arr[n-1] - k;

        if(small > big){
            int temp = small;
            small = big;
            big = temp;
        }

        // Traverse middle elements
        for(int i = 1; i < n-1; i++) {

            int subtract = arr[i] - k;
            int add = arr[i] + k;

            if(subtract >= small || add <= big)
                continue;

            if(big - subtract <= add - small)
                small = subtract;
            else
                big = add;
        }

        return Math.min(ans, big - small);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of towers: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input heights
        System.out.println("Enter heights:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Input k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        // Output
        System.out.println("Minimum possible difference: " + getMinDiff(arr, n, k));

        sc.close();
    }
}
