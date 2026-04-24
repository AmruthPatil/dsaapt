package dsa25;

import java.util.*;

public class PairSum {

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

        // input target sum
        System.out.print("Enter target sum: ");
        int k = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();

        System.out.println("Pairs with sum " + k + ":");

        for(int i = 0; i < n; i++) {

            int complement = k - arr[i];

            if(set.contains(complement)) {
                System.out.println("(" + complement + ", " + arr[i] + ")");
            }

            set.add(arr[i]);
        }

        sc.close();
    }
}
