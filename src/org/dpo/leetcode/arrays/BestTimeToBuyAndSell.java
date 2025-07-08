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

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            final int todayPrice = prices[i];
            if (todayPrice < minPrice) {
                minPrice = todayPrice;
            } else {
                int currentProfit = todayPrice - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }
}
