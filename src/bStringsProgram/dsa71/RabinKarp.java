package dsa71;

import java.util.*;

public class RabinKarp {

    static final int d = 256;

    public static void search(String pat, String txt, int q) {

        int m = pat.length();
        int n = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // h = pow(d, m-1) % q
        for(i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate initial hash
        for(i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide pattern over text
        for(i = 0; i <= n - m; i++) {

            // Check hash
            if(p == t) {
                for(j = 0; j < m; j++) {
                    if(txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                if(j == m)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate next hash
            if(i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                if(t < 0)
                    t = t + q;
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

        // Prime number
        int q = 101;

        search(pat, txt, q);

        sc.close();
    }
}
