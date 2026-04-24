package dsa29;

import java.util.*;

public class MaxProductSubarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // input elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int maxProd = arr[0];
        int minProd = arr[0];
        int result = arr[0];

        for(int i = 1; i < n; i++) {

            // if negative, swap
            if(arr[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);

            result = Math.max(result, maxProd);
        }

        System.out.println("Maximum product subarray = " + result);

        sc.close();
    }
}
