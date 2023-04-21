class Solution {
    int mod = (int)1e9 + 7;
    private int f(int ind,int members,int pro,int n,int minProfit,int[] group, int[] profit,int dp[][][]) {
        if(ind == group.length) return pro >= minProfit ? 1 : 0;
        if(dp[ind][members][pro] != -1) {
            return dp[ind][members][pro];
        }
        
        int take = 0;
        if(members + group[ind] <= n) {
            take = f(ind+1,members + group[ind],Math.min(minProfit, pro + profit[ind]),n,minProfit,group,profit,dp);
        }
        int nottake = f(ind+1,members,pro,n,minProfit,group,profit,dp);
        return dp[ind][members][pro] = (take + nottake) % mod;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][][] = new int[101][101][101];
        for(int it[][] : dp) {
            for(int iter[] : it) {
                Arrays.fill(iter,-1);
            }
        }
        return f(0,0,0,n,minProfit,group,profit,dp) % mod;
    }
}