package dsaapt;

import java.util.*;

public class MoveNegatives {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Two pointer logic
        int left = 0;
        int right = n - 1;

        while(left <= right) {

            // if left is negative, move ahead
            if(arr[left] < 0) {
                left++;
            }

            // if right is positive, move back
            else if(arr[right] > 0) {
                right--;
            }

            // swap
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        // Output result
        System.out.println("Array after moving negatives to one side:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
