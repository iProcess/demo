package com.example.demo.zjtd.network;

public class ProfitUtil {

    public static int maxProfit1(int[] prices) {
        //解法一：蛮力法，找到每一天后续的最大值，比较确定最大利润
        //时间复杂度：O(n^2),空间复杂度：O(1)
        if (prices == null || prices.length == 0)
            return 0;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) { //如果第i天买入，依次判断它之后的每一天卖出的情况
                if (prices[j] - prices[i] > maxprofit)
                    maxprofit = prices[j] - prices[i];
            }
        }
        return maxprofit;
    }

    public static int maxProfit2(int[] prices) {
        //解法二：动态规划法：用dp[i]表示第i天卖出的收益，则dp[i]=max(price[i]-min,maxProfit)
        //时间复杂度：O(n),空间复杂度：O(1)
        if (prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        int maxprofit = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min)   //维护一个最小值
                min = prices[i];
            else if (prices[i] - min > maxprofit)
                maxprofit = prices[i] - min;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));

    }

}
