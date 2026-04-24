package dsa34;

import java.util.*;

public class TripletSum {

    public static boolean findTriplet(int arr[], int n, int target) {

        Arrays.sort(arr);

        for(int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while(left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if(sum == target) {
                    System.out.println("Triplet found: " + arr[i] + " " + arr[left] + " " + arr[right]);
                    return true;
                }

                else if(sum < target) {
                    left++;
                }

                else {
                    right--;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        boolean result = findTriplet(arr, n, target);

        if(!result)
            System.out.println("No triplet found");

        sc.close();
    }
}
