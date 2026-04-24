package dsa75;

import java.util.*;

public class CountPalindromicSubsequence {

    public static int countPS(String str) {

        int n = str.length();
        int dp[][] = new int[n][n];

        // single characters
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // length of substring
        for(int len = 2; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if(str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int result = countPS(str);

        System.out.println("Count of Palindromic Subsequences = " + result);

        sc.close();
    }
}
