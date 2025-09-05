package org.dpo.leetcode.arrays;

public class BestTimeToBuyAndSell {


    public static void main(String[] args) {
        //int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices =   { 3,2,6,5,0,3};
        final int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int left = 0;
        int maxProfit = 0;
        for (int right = 1; right < prices.length; right++) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
        }

        return maxProfit;
    }
}
