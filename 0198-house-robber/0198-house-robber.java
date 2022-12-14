class Solution {
    private int solve(int ind ,int arr[],int dp[]){
        if(ind == 0){
            return arr[ind];
        }
        if(ind < 0 ){
            return 0;
        }
        if(dp[ind]!= -1){
            return dp[ind];
        }
        int rob = arr[ind] + solve(ind - 2,arr,dp);
        int skip = 0 + solve(ind-1,arr,dp);
        return dp[ind] = Math.max(rob,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
    }
}