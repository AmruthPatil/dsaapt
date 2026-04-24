package dsa66;

import java.util.*;

public class WordWrap {

    public static void solveWordWrap(int[] words, int n, int k) {
        int[][] extras = new int[n + 1][n + 1];
        int[][] lc = new int[n + 1][n + 1];
        int[] c = new int[n + 1];
        int[] p = new int[n + 1];

        // Calculate extra spaces
        for (int i = 1; i <= n; i++) {
            extras[i][i] = k - words[i - 1];
            for (int j = i + 1; j <= n; j++) {
                extras[i][j] = extras[i][j - 1] - words[j - 1] - 1;
            }
        }

        // Calculate line cost
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (extras[i][j] < 0)
                    lc[i][j] = Integer.MAX_VALUE;
                else if (j == n)
                    lc[i][j] = 0;
                else
                    lc[i][j] = extras[i][j] * extras[i][j];
            }
        }

        // DP to find minimum cost
        c[0] = 0;
        for (int j = 1; j <= n; j++) {
            c[j] = Integer.MAX_VALUE;
            for (int i = 1; i <= j; i++) {
                if (c[i - 1] != Integer.MAX_VALUE && lc[i][j] != Integer.MAX_VALUE
                        && c[i - 1] + lc[i][j] < c[j]) {
                    c[j] = c[i - 1] + lc[i][j];
                    p[j] = i;
                }
            }
        }

        System.out.println("Minimum cost = " + c[n]);
        printSolution(p, n);
    }

    public static void printSolution(int[] p, int n) {
        if (p[n] == 1)
            System.out.println("Line: Word " + p[n] + " to " + n);
        else {
            printSolution(p, p[n] - 1);
            System.out.println("Line: Word " + p[n] + " to " + n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of words
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        int[] words = new int[n];

        // Input word lengths
        System.out.println("Enter word lengths:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextInt();
        }

        // Input line width
        System.out.print("Enter line width: ");
        int k = sc.nextInt();

        solveWordWrap(words, n, k);

        sc.close();
    }
}
