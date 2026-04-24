package dsa33;

import java.util.*;

public class SubsetArray {

    public static boolean isSubset(int A[], int B[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // store frequency of A
        for(int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // check elements of B
        for(int num : B) {
            if(!map.containsKey(num) || map.get(num) == 0) {
                return false;
            }
            map.put(num, map.get(num) - 1);
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input array A
        System.out.print("Enter size of array A: ");
        int n = sc.nextInt();
        int A[] = new int[n];

        System.out.println("Enter elements of array A:");
        for(int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        // input array B
        System.out.print("Enter size of array B: ");
        int m = sc.nextInt();
        int B[] = new int[m];

        System.out.println("Enter elements of array B:");
        for(int i = 0; i < m; i++)
            B[i] = sc.nextInt();

        // check subset
        if(isSubset(A, B))
            System.out.println("Yes, B is a subset of A");
        else
            System.out.println("No, B is NOT a subset of A");

        sc.close();
    }
}