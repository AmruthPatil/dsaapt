package dsa36;

import java.util.*;

public class ChocolateDistribution {

    public static int findMinDiff(int arr[], int n, int m) {

        if(m == 0 || n == 0)
            return 0;

        if(n < m)
            return -1;

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i + m - 1 < n; i++) {
            int diff = arr[i + m - 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input chocolates
        System.out.println("Enter chocolates in packets:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input students
        System.out.print("Enter number of students: ");
        int m = sc.nextInt();

        int result = findMinDiff(arr, n, m);

        if(result == -1)
            System.out.println("Not enough packets");
        else
            System.out.println("Minimum difference = " + result);

        sc.close();
    }
}
