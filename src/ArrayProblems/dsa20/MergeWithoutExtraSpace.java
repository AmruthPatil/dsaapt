package dsa20;

import java.util.*;

public class MergeWithoutExtraSpace {

    // function to calculate next gap
    public static int nextGap(int gap) {
        if(gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void merge(int arr1[], int arr2[], int n, int m) {

        int gap = nextGap(n + m);

        while(gap > 0) {

            int i = 0;
            int j = gap;

            while(j < (n + m)) {

                // case 1: both pointers in arr1
                if(i < n && j < n) {
                    if(arr1[i] > arr1[j]) {
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    }
                }

                // case 2: i in arr1, j in arr2
                else if(i < n && j >= n) {
                    if(arr1[i] > arr2[j-n]) {
                        int temp = arr1[i];
                        arr1[i] = arr2[j-n];
                        arr2[j-n] = temp;
                    }
                }

                // case 3: both pointers in arr2
                else {
                    if(arr2[i-n] > arr2[j-n]) {
                        int temp = arr2[i-n];
                        arr2[i-n] = arr2[j-n];
                        arr2[j-n] = temp;
                    }
                }

                i++;
                j++;
            }

            gap = nextGap(gap);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // first array
        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();

        int arr1[] = new int[n];

        System.out.println("Enter elements of first sorted array:");
        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        // second array
        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();

        int arr2[] = new int[m];

        System.out.println("Enter elements of second sorted array:");
        for(int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();

        merge(arr1, arr2, n, m);

        // output merged arrays
        System.out.println("Merged arrays:");

        for(int i = 0; i < n; i++)
            System.out.print(arr1[i] + " ");

        for(int i = 0; i < m; i++)
            System.out.print(arr2[i] + " ");

        sc.close();
    }
}
