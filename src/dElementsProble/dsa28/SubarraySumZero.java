package dsa28;

import java.util.*;

public class SubarraySumZero {

    public static boolean hasZeroSumSubarray(int arr[]) {

        HashSet<Integer> set = new HashSet<>();

        int sum = 0;

        for(int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if(sum == 0 || set.contains(sum))
                return true;

            set.add(sum);
        }

        return false;
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

        if(hasZeroSumSubarray(arr))
            System.out.println("Yes, subarray with sum 0 exists");
        else
            System.out.println("No subarray with sum 0");

        sc.close();
    }
}
