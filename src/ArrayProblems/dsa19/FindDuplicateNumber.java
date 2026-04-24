package dsa19;

import java.util.*;

public class FindDuplicateNumber {

    public static int findDuplicate(int arr[]) {

        int slow = arr[0];
        int fast = arr[0];

        // Detect cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow != fast);

        // Find duplicate
        slow = arr[0];

        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size (N+1 elements)
        System.out.print("Enter number of elements (N+1): ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter elements (values must be between 1 and N):");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int duplicate = findDuplicate(arr);

        System.out.println("Duplicate element: " + duplicate);

        sc.close();
    }
}
