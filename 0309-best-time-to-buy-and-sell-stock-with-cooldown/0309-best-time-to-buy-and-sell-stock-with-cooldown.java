class Solution {
    private int f(int ind,int buy,int[] prices,int dp[][]){
        if(ind >= prices.length) return  0;
        if(dp[ind][buy] != -1){
            return dp[ind][buy];           
        }
        if(buy == 1){
            return dp[ind][buy] = Math.max(-prices[ind] + f(ind + 1,0,prices,dp),
                              0 + f(ind+1,1,prices,dp));
        }
        //for the cooldown we cannot go to the next day for buy just after selling the stock so we go to day after the day
        return dp[ind][buy] = Math.max(prices[ind] + f(ind+2,1,prices,dp),
                                       0 + f(ind+1,0,prices,dp));
    }
    public int maxProfit(int[] prices) {
        int n  = prices.length;
        int dp[][]= new int[n][2];
        for(int row[] : dp) Arrays.fill(row,-1);
        return f(0,1,prices,dp);
    }
}