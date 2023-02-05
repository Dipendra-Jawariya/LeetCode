class Solution {
    private int f(int ind,int buy,int prices[],int dp[][]){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        int profit = Integer.MIN_VALUE;
        if(buy == 1){ //buy --> buy 
                        //  --> NOT BUY
            profit = Math.max(-prices[ind] + f(ind+1,0,prices,dp),
                                0 + f(ind+1,1,prices,dp));
        }else{ // sell -->  sell
                //     --> not sell
            profit = Math.max(prices[ind] + f(ind+1,1,prices,dp),
                              0 + f(ind+1,0,prices,dp));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int rows[] : dp){
            Arrays.fill(rows,0);
        }
        
        //base case
        dp[n][0] = dp[n][1] = 0;
        
        for(int ind = n-1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = Integer.MIN_VALUE;
                if(buy == 1){ //buy --> buy 
                                //  --> NOT BUY
                    profit = Math.max(-prices[ind] + dp[ind+1][0],
                                        0 + dp[ind+1][1]);
                }else{ // sell -->  sell
                        //     --> not sell
                    profit = Math.max(prices[ind] + dp[ind+1][1],
                                      0 + dp[ind+1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
}