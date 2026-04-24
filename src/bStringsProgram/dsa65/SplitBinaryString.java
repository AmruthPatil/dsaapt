package dsa65;

import java.util.*;

public class SplitBinaryString {

    public static int maxSubStr(String str) {

        int count0 = 0, count1 = 0, count = 0;

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '0')
                count0++;
            else if(str.charAt(i) == '1')
                count1++;

            if(count0 == count1)
                count++;
        }

        if(count0 != count1)
            return -1;

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input binary string
        System.out.print("Enter a binary string: ");
        String str = sc.nextLine();

        int result = maxSubStr(str);

        if(result == -1)
            System.out.println("Not possible");
        else
            System.out.println("Maximum number of substrings = " + result);

        sc.close();
    }
}
