package dsa38;
import java.util.*;

public class ThreeWayPartition {

    public static void partition(int arr[], int n, int a, int b) {

        int low = 0, mid = 0, high = n - 1;

        while(mid <= high) {

            if(arr[mid] < a) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }

            else if(arr[mid] > b) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }

            else {
                mid++;
            }
        }
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

        // Input range
        System.out.print("Enter value of a: ");
        int a = sc.nextInt();

        System.out.print("Enter value of b: ");
        int b = sc.nextInt();

        partition(arr, n, a, b);

        System.out.println("Array after three-way partitioning:");

        for(int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
