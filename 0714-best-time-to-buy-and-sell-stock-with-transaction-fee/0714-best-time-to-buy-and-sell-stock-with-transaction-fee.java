class Solution {
    private int f(int ind,int buy,int prices[],int dp[][],int fee){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        int profit = Integer.MIN_VALUE;
        if(buy == 1){ //buy --> buy 
                        //  --> NOT BUY
            profit = Math.max(-prices[ind] - fee + f(ind+1,0,prices,dp,fee),
                                0 + f(ind+1,1,prices,dp,fee));
        }else{ // sell -->  sell
                //     --> not sell
            profit = Math.max(prices[ind] + f(ind+1,1,prices,dp,fee),
                              0 + f(ind+1,0,prices,dp,fee));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[] : dp) Arrays.fill(row,-1);
        return f(0,1,prices,dp,fee);
    }
}