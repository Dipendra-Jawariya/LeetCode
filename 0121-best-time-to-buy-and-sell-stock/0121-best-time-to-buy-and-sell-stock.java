class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            mini = Math.min(mini,prices[i]);
            profit = Math.max(profit,cost);
        }
        return profit;
    }
}