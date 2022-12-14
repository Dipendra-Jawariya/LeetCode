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
    public int rob(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        // return solve(n-1,nums,dp);
//         Tabulation
        // dp[0] = arr[0];
        // int max = Integer.MIN_VALUE;
        // for(int i =1;i<n;i++){
        //     int pick = arr[i];
        //     if(i >1){
        //         pick+= dp[i-2];
        //     }
        //     int skip = dp[i-1];
        //     dp[i] = Math.max(pick,skip);
        // }
        // return dp[n-1];
        
        
//         Space Optimization
        int prev2 = 0;
        int prev = arr[0];
        for(int i =1;i<n;i++){
            int rob= arr[i];
            if(i>1){
                rob += prev2;
            }
            int skip = 0 + prev;
            int curr_i = Math.max(rob,skip);
            prev2 = prev;
            prev = curr_i;
         }
        return prev;
    }
}