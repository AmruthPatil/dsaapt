package dsa18;

import java.util.*;

public class MinimumJumps {

    public static int minJumps(int arr[], int n) {

        if(n <= 1)
            return 0;

        if(arr[0] == 0)
            return -1;

        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for(int i = 1; i < n; i++) {

            // reached end
            if(i == n - 1)
                return jump;

            // update maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            step--;

            // if no more steps left
            if(step == 0) {

                jump++;

                // cannot move forward
                if(i >= maxReach)
                    return -1;

                step = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int result = minJumps(arr, n);

        if(result == -1)
            System.out.println("Cannot reach the end");
        else
            System.out.println("Minimum number of jumps: " + result);

        sc.close();
    }
}
