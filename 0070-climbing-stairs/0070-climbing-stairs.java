class Solution {
    public int climbStairs(int n) {
//         Tabulation
         int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =2; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
//         Memoization
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // if(n ==0){
        //     return 1;
        // }
        // if(n ==1){
        //     return 1;
        // }
        // if(dp[n]!= -1){
        //     return dp[n];
        // }
        // int left = climbStairs(n-1);
        // int right = climbStairs(n-2);
        // return left + right;
        
//         Recursion
        // if(n == 0){
        //     return 1;
        // }
        // if(n == 1){
        //     return 1;
        // }
        // int left = climbStairs(n-1);
        // int right = climbStairs(n-2);
        // return left + right;
    }
}