class Solution {
    private int f(int ind,int transNo,int prices[],int n ,int k,int dp[][]){
        if(ind == n || transNo == 2 * k) return 0;
        if(dp[ind][transNo] != -1) return dp[ind][transNo];
        if(transNo % 2 == 0) //buy
        {
            return dp[ind][transNo] = Math.max(-prices[ind] + f(ind + 1,transNo + 1,prices,n,k,dp),
                            0 + f(ind +1,transNo,prices,n,k,dp));
        }
        return dp[ind][transNo] = Math.max(prices[ind] + f(ind + 1,transNo + 1,prices,n,k,dp),
                        0 + f(ind + 1,transNo,prices,n,k,dp));
    }
    
    
    
    public int maxProfit(int k, int[] prices) {
        int  n = prices.length;
        int dp[][] = new int[n+1][2 * k + 1]; 
        for(int row[] : dp) Arrays.fill(row,0);
        for(int ind = n - 1; ind >= 0; ind--){
            for(int transNo = 2 * k -1;transNo >= 0; transNo--){
                if(transNo % 2 == 0) //buy
                {
                     dp[ind][transNo] = Math.max(-prices[ind] + dp[ind + 1][transNo + 1],0 + dp[ind +1][transNo]);
                }
                else dp[ind][transNo] = Math.max(prices[ind] + dp[ind + 1][transNo + 1], 0 + dp[ind + 1][transNo]);
            }
        }
        return dp[0][0];
    }
}