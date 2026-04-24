package dsa58;

import java.util.*;

public class StringRotation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input strings
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        if(str1.length() == str2.length() && (str1 + str1).contains(str2)) {
            System.out.println("Yes, second string is a rotation of first");
        } else {
            System.out.println("No, second string is not a rotation of first");
        }

        sc.close();
    }
}
