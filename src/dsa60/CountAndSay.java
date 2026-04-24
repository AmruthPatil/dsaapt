package dsa60;

import java.util.*;

public class CountAndSay {

    public static String countAndSay(int n) {

        if(n == 1)
            return "1";

        String result = "1";

        for(int i = 2; i <= n; i++) {

            StringBuilder temp = new StringBuilder();
            int count = 1;

            for(int j = 0; j < result.length(); j++) {

                while(j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                    j++;
                }

                temp.append(count).append(result.charAt(j));
                count = 1;
            }

            result = temp.toString();
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input n
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        System.out.println("Nth term = " + countAndSay(n));

        sc.close();
    }
}