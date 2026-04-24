package dsa79;

import java.util.*;

public class RomanToDecimal {

    public static int value(char r) {
        switch(r) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return -1;
    }

    public static int romanToInt(String str) {
        int res = 0;

        for(int i = 0; i < str.length(); i++) {

            int s1 = value(str.charAt(i));

            if(i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                if(s1 >= s2) {
                    res += s1;
                } else {
                    res += (s2 - s1);
                    i++;
                }
            } else {
                res += s1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input Roman numeral
        System.out.print("Enter Roman Numeral: ");
        String str = sc.nextLine().toUpperCase();

        System.out.println("Decimal value = " + romanToInt(str));

        sc.close();
    }
}
