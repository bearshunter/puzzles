package org.dpo.leetcode.top150;

public class BestTimeToBuyAndSell {

    public static void main(String[] args) {
        int[] prices = new int[]{2, 1, 2, 0, 1};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

/*    Example 1:

    Input: prices = [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Total profit is 4 + 3 = 7.
    Example 2:

    Input: prices = [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
    Total profit is 4.
    Example 3:

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.*/

    //[[7,1,5,3,6,4]]
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        if (prices.length == 0) {
            return maxProfit;
        }
        int investment = 0;
        int yesterdaysPrice = prices[0];
        boolean investmentIsDone = false;
        if (yesterdaysPrice == 1) {
            investment = 1;
            investmentIsDone = true;
        }
        if (prices.length > 1 && yesterdaysPrice < prices[1]) {
            investment = yesterdaysPrice;
            investmentIsDone = true;

        }

        for (int index = 1; index < prices.length; index++) {
            int priceOfToday = prices[index];
            int priceOfTomorrow = prices.length <= index + 1 ? 0 : prices[index + 1];

            if (!investmentIsDone && (yesterdaysPrice < priceOfToday || priceOfTomorrow > priceOfToday)) {
                investment = priceOfToday;
                investmentIsDone = true;
            }

            if (investmentIsDone && priceOfTomorrow < priceOfToday && priceOfToday > investment) {
                //sell and make profit
                maxProfit = maxProfit + (priceOfToday - investment);
                investment = 0;
                investmentIsDone = false;
            }


            yesterdaysPrice = priceOfToday;

        }


        return maxProfit;

    }
}
