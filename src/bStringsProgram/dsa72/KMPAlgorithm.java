package dsa72;

import java.util.*;

public class KMPAlgorithm {

    // Build LPS array
    public static void computeLPS(String pat, int[] lps) {
        int len = 0;
        int i = 1;

        lps[0] = 0;

        while(i < pat.length()) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } 
            else {
                if(len != 0) {
                    len = lps[len - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // KMP Search
    public static void KMPSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();

        int[] lps = new int[m];
        computeLPS(pat, lps);

        int i = 0, j = 0;

        while(i < n) {
            if(pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if(j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            }

            else if(i < n && pat.charAt(j) != txt.charAt(i)) {
                if(j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input text
        System.out.print("Enter text: ");
        String txt = sc.nextLine();

        // Input pattern
        System.out.print("Enter pattern: ");
        String pat = sc.nextLine();

        KMPSearch(pat, txt);

        sc.close();
    }
}
