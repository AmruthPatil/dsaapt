package dsa27;

import java.util.*;

public class AlternatePositiveNegative {

    // function to right rotate
    static void rightRotate(int arr[], int start, int end) {

        int temp = arr[end];

        for(int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }

        arr[start] = temp;
    }

    public static void rearrange(int arr[], int n) {

        for(int i = 0; i < n; i++) {

            // check if element is wrongly placed
            if((i % 2 == 0 && arr[i] < 0) || 
               (i % 2 == 1 && arr[i] >= 0)) {

                int j = i + 1;

                // find next opposite sign element
                while(j < n) {

                    if((arr[i] >= 0 && arr[j] < 0) ||
                       (arr[i] < 0 && arr[j] >= 0)) {
                        break;
                    }

                    j++;
                }

                // if found rotate
                if(j < n) {
                    rightRotate(arr, i, j);
                }
            }
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

        rearrange(arr, n);

        // output
        System.out.println("Array after rearranging:");

        for(int num : arr)
            System.out.print(num + " ");

        sc.close();
    }
}
