package dsa37;
import java.util.*;

public class SmallestSubarray {

    public static int smallestSubWithSum(int arr[], int n, int x) {

        int minLen = n + 1;
        int sum = 0, start = 0;

        for(int end = 0; end < n; end++) {

            sum += arr[end];

            while(sum > x) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        return (minLen == n + 1) ? 0 : minLen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter positive elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target
        System.out.print("Enter value of x: ");
        int x = sc.nextInt();

        int result = smallestSubWithSum(arr, n, x);

        if(result == 0)
            System.out.println("No such subarray exists");
        else
            System.out.println("Smallest subarray length = " + result);

        sc.close();
    }
}
