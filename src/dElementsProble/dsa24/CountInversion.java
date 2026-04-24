package dsa24;
import java.util.*;

public class CountInversion {

    public static long merge(int arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for(int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        long invCount = 0;

        while(i < n1 && j < n2) {

            if(L[i] <= R[j]) {
                arr[k++] = L[i++];
            }

            else {
                arr[k++] = R[j++];
                invCount += (n1 - i);
            }
        }

        while(i < n1)
            arr[k++] = L[i++];

        while(j < n2)
            arr[k++] = R[j++];

        return invCount;
    }

    public static long mergeSort(int arr[], int left, int right) {

        long invCount = 0;

        if(left < right) {

            int mid = (left + right) / 2;

            invCount += mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid + 1, right);

            invCount += merge(arr, left, mid, right);
        }

        return invCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // input elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long result = mergeSort(arr, 0, n - 1);

        System.out.println("Number of inversions: " + result);

        sc.close();
    }
}

