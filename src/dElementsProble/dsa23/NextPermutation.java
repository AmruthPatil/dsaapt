package dsa23;

import java.util.*;

public class NextPermutation {

    public static void nextPermutation(int arr[]) {

        int n = arr.length;
        int i = n - 2;

        // step 1: find first decreasing element
        while(i >= 0 && arr[i] >= arr[i + 1])
            i--;

        // step 2: find element just greater than arr[i]
        if(i >= 0) {
            int j = n - 1;

            while(arr[j] <= arr[i])
                j--;

            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // step 3: reverse remaining array
        int start = i + 1;
        int end = n - 1;

        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

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

        nextPermutation(arr);

        // output
        System.out.println("Next Permutation:");

        for(int num : arr)
            System.out.print(num + " ");

        sc.close();
    }
}
