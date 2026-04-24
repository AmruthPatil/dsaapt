package dsa52;

import java.util.*;

public class CommonElementsRows {

    public static void findCommon(int arr[][], int r, int c) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // First row elements
        for(int j = 0; j < c; j++) {
            map.put(arr[0][j], 1);
        }

        // Traverse remaining rows
        for(int i = 1; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map.containsKey(arr[i][j]) && map.get(arr[i][j]) == i) {
                    map.put(arr[i][j], i + 1);
                }
            }
        }

        System.out.println("Common elements in all rows:");

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == r) {
                System.out.print(entry.getKey() + " ");
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
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        findCommon(arr, r, c);

        sc.close();
    }
}
