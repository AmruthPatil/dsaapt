package dsa51;

import java.util.*;

public class KthSmallestMatrix {

    static class Node {
        int value, row, col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static int kthSmallest(int arr[][], int n, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.value - b.value
        );

        // insert first element of each row
        for(int i = 0; i < n; i++) {
            pq.add(new Node(arr[i][0], i, 0));
        }

        Node curr = null;

        for(int i = 0; i < k; i++) {
            curr = pq.poll();

            if(curr.col + 1 < n) {
                pq.add(new Node(arr[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }

        return curr.value;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter size of square matrix: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];

        // input matrix
        System.out.println("Enter row-column wise sorted matrix:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // input k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        int result = kthSmallest(arr, n, k);

        System.out.println("Kth smallest element = " + result);

        sc.close();
    }
}
