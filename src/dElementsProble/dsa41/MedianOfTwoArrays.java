package dsa41;

import java.util.*;

public class MedianOfTwoArrays {

    public static int getMedian(int arr1[], int arr2[], int n) {

        int i = 0, j = 0;
        int m1 = -1, m2 = -1;

        for(int count = 0; count <= n; count++) {

            m1 = m2;

            if(i == n) {
                m2 = arr2[0];
                break;
            }

            else if(j == n) {
                m2 = arr1[0];
                break;
            }

            if(arr1[i] <= arr2[j]) {
                m2 = arr1[i];
                i++;
            }

            else {
                m2 = arr2[j];
                j++;
            }
        }

        return (m1 + m2) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter size of arrays: ");
        int n = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        // Input first array
        System.out.println("Enter elements of first sorted array:");
        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input second array
        System.out.println("Enter elements of second sorted array:");
        for(int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        int result = getMedian(arr1, arr2, n);

        System.out.println("Median = " + result);

        sc.close();
    }
}