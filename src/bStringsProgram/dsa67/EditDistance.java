package dsa67;

import java.util.*;

public class EditDistance {

    public static int minDistance(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {

                if(i == 0)
                    dp[i][j] = j;

                else if(j == 0)
                    dp[i][j] = i;

                else if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],   // replace
                                   Math.min(dp[i - 1][j],       // delete
                                            dp[i][j - 1]));     // insert
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input strings
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int result = minDistance(s1, s2);

        System.out.println("Minimum Edit Distance = " + result);

        sc.close();
    }
}