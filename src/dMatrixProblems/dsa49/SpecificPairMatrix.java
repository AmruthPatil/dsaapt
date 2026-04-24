package dsa49;

import java.util.*;

public class SpecificPairMatrix {

    public static int findMaxValue(int mat[][], int n) {

        int maxArr[][] = new int[n][n];

        int maxValue = Integer.MIN_VALUE;

        // Initialize last element
        maxArr[n-1][n-1] = mat[n-1][n-1];

        // Last row
        int maxv = mat[n-1][n-1];
        for(int j = n-2; j >= 0; j--) {
            if(mat[n-1][j] > maxv)
                maxv = mat[n-1][j];
            maxArr[n-1][j] = maxv;
        }

        // Last column
        maxv = mat[n-1][n-1];
        for(int i = n-2; i >= 0; i--) {
            if(mat[i][n-1] > maxv)
                maxv = mat[i][n-1];
            maxArr[i][n-1] = maxv;
        }

        // Process rest of matrix
        for(int i = n-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {

                maxValue = Math.max(maxValue, maxArr[i+1][j+1] - mat[i][j]);

                maxArr[i][j] = Math.max(mat[i][j],
                                Math.max(maxArr[i][j+1], maxArr[i+1][j]));
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter size of square matrix: ");
        int n = sc.nextInt();

        int mat[][] = new int[n][n];

        // Input matrix
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int result = findMaxValue(mat, n);

        System.out.println("Maximum value pair = " + result);

        sc.close();
    }
}
