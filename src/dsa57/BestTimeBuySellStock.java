package dsa57;

import java.util.*;

public class BestTimeBuySellStock {

    public static int maxProfit(int prices[], int n) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < n; i++) {

            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            else if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of days
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int prices[] = new int[n];

        // Input prices
        System.out.println("Enter stock prices:");
        for(int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices, n);

        System.out.println("Maximum Profit = " + result);

        sc.close();
    }
}