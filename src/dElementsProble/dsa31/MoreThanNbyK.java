package dsa31;

import java.util.*;

public class MoreThanNbyK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println("Elements appearing more than n/k times:");

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > n / k) {
                System.out.print(entry.getKey() + " ");
            }
        }

        sc.close();
    }
}
