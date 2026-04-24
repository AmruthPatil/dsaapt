package dsa42;

import java.util.*;

public class MedianDifferentSize {

    public static double findMedian(int arr1[], int arr2[]) {

        int n = arr1.length;
        int m = arr2.length;

        int merged[] = new int[n + m];

        int i = 0, j = 0, k = 0;

        // Merge arrays
        while(i < n && j < m) {
            if(arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while(i < n) {
            merged[k++] = arr1[i++];
        }

        while(j < m) {
            merged[k++] = arr2[j++];
        }

        int total = n + m;

        // Find median
        if(total % 2 == 1) {
            return merged[total / 2];
        } else {
            return (merged[(total / 2) - 1] + merged[total / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input first array
        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();
        int arr1[] = new int[n];

        System.out.println("Enter elements of first sorted array:");
        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input second array
        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();
        int arr2[] = new int[m];

        System.out.println("Enter elements of second sorted array:");
        for(int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        double result = findMedian(arr1, arr2);

        System.out.println("Median = " + result);

        sc.close();
    }
}