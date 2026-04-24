package dsa45;

import java.util.*;

public class MatrixMedian {

    public static int countSmallerThanEqual(int row[], int x) {
        int low = 0, high = row.length;

        while(low < high) {
            int mid = (low + high) / 2;

            if(row[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static int findMedian(int arr[][], int r, int c) {

        int min = arr[0][0];
        int max = arr[0][c - 1];

        for(int i = 1; i < r; i++) {
            if(arr[i][0] < min)
                min = arr[i][0];

            if(arr[i][c - 1] > max)
                max = arr[i][c - 1];
        }

        int desired = (r * c + 1) / 2;

        while(min < max) {
            int mid = (min + max) / 2;
            int place = 0;

            for(int i = 0; i < r; i++) {
                place += countSmallerThanEqual(arr[i], mid);
            }

            if(place < desired)
                min = mid + 1;
            else
                max = mid;
        }

        return min;
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
        System.out.println("Enter row-wise sorted matrix:");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int result = findMedian(arr, r, c);

        System.out.println("Median = " + result);

        sc.close();
    }
}