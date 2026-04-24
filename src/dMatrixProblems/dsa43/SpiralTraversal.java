package dsa43;

import java.util.*;

public class SpiralTraversal {

    public static void spiralPrint(int arr[][], int m, int n) {

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        System.out.println("Spiral Traversal:");

        while(top <= bottom && left <= right) {

            // left to right
            for(int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

            // top to bottom
            for(int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;

            // right to left
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }

            // bottom to top
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];

        // Input matrix
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        spiralPrint(arr, m, n);

        sc.close();
    }
}
