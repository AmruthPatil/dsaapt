package dsa46;

import java.util.*;

public class RowWithMaxOnes {

    public static int rowWithMax1s(int arr[][], int r, int c) {

        int j = c - 1;
        int maxRow = -1;

        for(int i = 0; i < r; i++) {
            while(j >= 0 && arr[i][j] == 1) {
                j--;
                maxRow = i;
            }
        }

        return maxRow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        int arr[][] = new int[r][c];

        // Input matrix
        System.out.println("Enter binary matrix:");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int result = rowWithMax1s(arr, r, c);

        if(result != -1)
            System.out.println("Row with maximum 1s = " + result);
        else
            System.out.println("No 1s found in matrix");

        sc.close();
    }
}