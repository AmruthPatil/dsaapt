package dsa70;

import java.util.*;

public class WordBreakProblem {

    public static boolean wordBreak(String s, Set<String> dict) {

        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {

                if(dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        // Input dictionary size
        System.out.print("Enter number of dictionary words: ");
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> dict = new HashSet<>();

        System.out.println("Enter dictionary words:");
        for(int i = 0; i < n; i++) {
            dict.add(sc.nextLine());
        }

        if(wordBreak(s, dict))
            System.out.println("Yes, string can be segmented");
        else
            System.out.println("No, string cannot be segmented");

        sc.close();
    }
}
