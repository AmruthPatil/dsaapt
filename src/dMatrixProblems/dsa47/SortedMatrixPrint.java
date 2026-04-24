package dsa47;

import java.util.*;

public class SortedMatrixPrint {

    static class Element {
        int value, row, col;

        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static void printSorted(int arr[][], int r, int c) {

        PriorityQueue<Element> pq = new PriorityQueue<>(
            (a, b) -> a.value - b.value
        );

        // Insert first element of each row
        for(int i = 0; i < r; i++) {
            pq.add(new Element(arr[i][0], i, 0));
        }

        System.out.println("Elements in sorted order:");

        while(!pq.isEmpty()) {
            Element curr = pq.poll();

            System.out.print(curr.value + " ");

            if(curr.col + 1 < c) {
                pq.add(new Element(arr[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }
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
        System.out.println("Enter row-column wise sorted matrix:");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        printSorted(arr, r, c);

        sc.close();
    }
}