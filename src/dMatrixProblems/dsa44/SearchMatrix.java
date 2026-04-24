package dsa44;

import java.util.*;

public class SearchMatrix {

    public static void search(int arr[][], int m, int n, int key) {

        int i = 0, j = n - 1;

        while(i < m && j >= 0) {

            if(arr[i][j] == key) {
                System.out.println("Element found at position (" + i + "," + j + ")");
                return;
            }

            else if(arr[i][j] > key) {
                j--;
            }

            else {
                i++;
            }
        }

        System.out.println("Element not found");
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

        // Input key
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        search(arr, m, n, key);

        sc.close();
    }
}
