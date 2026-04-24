package dsa32;

import java.util.*;

public class BuySellAtMostTwice {

    public static int maxProfit(int price[], int n) {

        int profit[] = new int[n];

        // Traverse from right to left
        int maxPrice = price[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            if(price[i] > maxPrice)
                maxPrice = price[i];

            profit[i] = Math.max(profit[i + 1], maxPrice - price[i]);
        }

        // Traverse from left to right
        int minPrice = price[0];

        for(int i = 1; i < n; i++) {
            if(price[i] < minPrice)
                minPrice = price[i];

            profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - minPrice));
        }

        return profit[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of days
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int price[] = new int[n];

        // Input prices
        System.out.println("Enter stock prices:");
        for(int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        int result = maxProfit(price, n);

        System.out.println("Maximum Profit = " + result);

        sc.close();
    }
}