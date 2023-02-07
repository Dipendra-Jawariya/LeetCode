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
        int dp[][]= new int[n+2][2];
        for(int row[] : dp) Arrays.fill(row,0);
        
        for(int ind = n-1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                     dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0],0+ dp[ind+1][1]);
                }else{
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind+2][1],
                                       0 + dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}