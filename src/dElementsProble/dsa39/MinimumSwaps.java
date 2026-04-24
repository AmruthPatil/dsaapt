package dsa39;
import java.util.*;

public class MinimumSwaps {

    public static int minSwaps(int arr[], int n, int k) {

        // Count good elements
        int good = 0;
        for(int num : arr) {
            if(num <= k)
                good++;
        }

        // Count bad elements in first window
        int bad = 0;
        for(int i = 0; i < good; i++) {
            if(arr[i] > k)
                bad++;
        }

        int ans = bad;

        // Slide window
        for(int i = 0, j = good; j < n; i++, j++) {

            if(arr[i] > k)
                bad--;

            if(arr[j] > k)
                bad++;

            ans = Math.min(ans, bad);
        }

        return ans;
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

        // Input K
        System.out.print("Enter value of K: ");
        int k = sc.nextInt();

        int result = minSwaps(arr, n, k);

        System.out.println("Minimum swaps required = " + result);

        sc.close();
    }
}