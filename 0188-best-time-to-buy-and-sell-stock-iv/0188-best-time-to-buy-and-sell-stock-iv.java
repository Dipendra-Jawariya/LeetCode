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
        // int dp[][] = new int[n+1][2 * k + 1]; 
        int after[] = new int[2 * k +1];
        int cur[] = new int[2 * k +1];
        Arrays.fill(after,0);
        for(int ind = n - 1; ind >= 0; ind--){
            for(int transNo = 2 * k -1;transNo >= 0; transNo--){
                if(transNo % 2 == 0) //buy
                {
                     cur[transNo] = Math.max(-prices[ind] + after[transNo + 1],0 + after[transNo]);
                }
                else cur[transNo] = Math.max(prices[ind] + after[transNo + 1], 0 + after[transNo]);
            }
            after = cur;
        }
        return after[0];
    }
}