package dsa50;

import java.util.*;

public class RotateMatrix90 {

    public static void rotate(int arr[][], int n) {

        // Step 1: Transpose
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for(int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while(left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter size of square matrix: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];

        // Input matrix
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        rotate(arr, n);

        System.out.println("Matrix after 90 degree rotation:");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}