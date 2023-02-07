class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int dp[][][] = new int[n+1][k+1][3];
        int after[][] = new int[2][k+1];
        int cur[][] = new int[2][k+1];
        
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
                for(int cap = 1; cap <= k; cap++){
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
        return after[1][k];
    }
}