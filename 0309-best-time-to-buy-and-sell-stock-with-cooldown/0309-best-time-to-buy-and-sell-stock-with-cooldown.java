class Solution {
    
    private int func(int ind,int buy,int prices[],int dp[][]){
        if(ind >= prices.length) return 0;
        if(dp[ind][buy]!= -1) return dp[ind][buy];
        if(buy == 1){
            return dp[ind][buy] = Math.max(-prices[ind] + func(ind+1,0,prices,dp) ,
                            0 +  func(ind+1,1,prices,dp));
        }
            return dp[ind][buy] = Math.max(prices[ind] + func(ind+2,1,prices,dp),
                            0 + func(ind+1,0,prices,dp));
        
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
          for(int row[]: dp)
            Arrays.fill(row,-1);
    
        return func(0,1,prices,dp);
    }
}