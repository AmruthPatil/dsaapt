package dsa48;

import java.util.*;

public class MaximumRectangle {

    // Largest Rectangle in Histogram
    public static int largestArea(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int i = 0;

        while(i < n) {
            if(st.isEmpty() || arr[st.peek()] <= arr[i]) {
                st.push(i++);
            } else {
                int top = st.pop();
                int area = arr[top] * (st.isEmpty() ? i : i - st.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        while(!st.isEmpty()) {
            int top = st.pop();
            int area = arr[top] * (st.isEmpty() ? i : i - st.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int maxRectangle(int arr[][], int r, int c) {
        int result = largestArea(arr[0], c);

        for(int i = 1; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(arr[i][j] == 1)
                    arr[i][j] += arr[i - 1][j];
                else
                    arr[i][j] = 0;
            }

            result = Math.max(result, largestArea(arr[i], c));
        }

        return result;
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

        int result = maxRectangle(arr, r, c);

        System.out.println("Maximum rectangle area = " + result);

        sc.close();
    }
}