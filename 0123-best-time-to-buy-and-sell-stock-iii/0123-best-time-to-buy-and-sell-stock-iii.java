class Solution {
    private int f(int ind,int buy,int cap,int[] prices,int dp[][][]){
        if(ind == prices.length) return 0;
        if(cap == 0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        if(buy == 1){
            return dp[ind][buy][cap] = Math.max(-prices[ind] + f(ind+1,0,cap,prices,dp) ,
                             0  + f(ind+1,1,cap,prices,dp));
        }else{
            return dp[ind][buy][cap] = Math.max( prices[ind] + f(ind + 1, 1, cap-1,prices,dp),
                             0 + f(ind + 1,0,cap,prices,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int row[][] : dp ) 
            for(int it[] : row){
                Arrays.fill(it,-1);
            }
        return f(0,1,2,prices,dp);
    }
}