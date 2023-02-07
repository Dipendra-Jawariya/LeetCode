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
        // int dp[][][] = new int[n+1][2][3];
        int after[][] = new int[2][3];
        int cur[][] = new int[2][3];
        
        for(int row[] : after) 
            // for(int it[] : row){
                Arrays.fill(row,0);
            // }
        
        //base case
        // for(int ind = 0;ind < n; ind++){
        //     for(int buy = 0;buy < 2;buy++){
        //         dp[ind][buy][cap] = 0;
        //     }
        // }
        // //second base case
        // for(int buy = 0;buy < 2;buy++){
        //     for(int cap = 0;cap<2;cap++){
        //         dp[n][buy][cap] = 0;
        //     }
        // }
        
        for(int ind = n-1;ind >= 0;ind--) {
            for(int buy = 0;buy <= 1;buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 1){
                         cur[buy][cap] = Math.max(-prices[ind] + after[0][cap] ,
                                         0  + after[1][cap]);
                    }else{
                         cur[buy][cap] = Math.max( prices[ind] + after[1][cap-1], 0 + after[0][cap]);
                    }
                }
            }
            after = cur;
        }
        return after[1][2];
    }
}