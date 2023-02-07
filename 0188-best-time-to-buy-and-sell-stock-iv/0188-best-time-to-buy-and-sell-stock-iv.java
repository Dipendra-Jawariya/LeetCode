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
        int dp[][] = new int[n][2 * k]; 
        for(int row[] : dp) Arrays.fill(row,-1);
        return f(0,0,prices,n,k,dp);
    }
}