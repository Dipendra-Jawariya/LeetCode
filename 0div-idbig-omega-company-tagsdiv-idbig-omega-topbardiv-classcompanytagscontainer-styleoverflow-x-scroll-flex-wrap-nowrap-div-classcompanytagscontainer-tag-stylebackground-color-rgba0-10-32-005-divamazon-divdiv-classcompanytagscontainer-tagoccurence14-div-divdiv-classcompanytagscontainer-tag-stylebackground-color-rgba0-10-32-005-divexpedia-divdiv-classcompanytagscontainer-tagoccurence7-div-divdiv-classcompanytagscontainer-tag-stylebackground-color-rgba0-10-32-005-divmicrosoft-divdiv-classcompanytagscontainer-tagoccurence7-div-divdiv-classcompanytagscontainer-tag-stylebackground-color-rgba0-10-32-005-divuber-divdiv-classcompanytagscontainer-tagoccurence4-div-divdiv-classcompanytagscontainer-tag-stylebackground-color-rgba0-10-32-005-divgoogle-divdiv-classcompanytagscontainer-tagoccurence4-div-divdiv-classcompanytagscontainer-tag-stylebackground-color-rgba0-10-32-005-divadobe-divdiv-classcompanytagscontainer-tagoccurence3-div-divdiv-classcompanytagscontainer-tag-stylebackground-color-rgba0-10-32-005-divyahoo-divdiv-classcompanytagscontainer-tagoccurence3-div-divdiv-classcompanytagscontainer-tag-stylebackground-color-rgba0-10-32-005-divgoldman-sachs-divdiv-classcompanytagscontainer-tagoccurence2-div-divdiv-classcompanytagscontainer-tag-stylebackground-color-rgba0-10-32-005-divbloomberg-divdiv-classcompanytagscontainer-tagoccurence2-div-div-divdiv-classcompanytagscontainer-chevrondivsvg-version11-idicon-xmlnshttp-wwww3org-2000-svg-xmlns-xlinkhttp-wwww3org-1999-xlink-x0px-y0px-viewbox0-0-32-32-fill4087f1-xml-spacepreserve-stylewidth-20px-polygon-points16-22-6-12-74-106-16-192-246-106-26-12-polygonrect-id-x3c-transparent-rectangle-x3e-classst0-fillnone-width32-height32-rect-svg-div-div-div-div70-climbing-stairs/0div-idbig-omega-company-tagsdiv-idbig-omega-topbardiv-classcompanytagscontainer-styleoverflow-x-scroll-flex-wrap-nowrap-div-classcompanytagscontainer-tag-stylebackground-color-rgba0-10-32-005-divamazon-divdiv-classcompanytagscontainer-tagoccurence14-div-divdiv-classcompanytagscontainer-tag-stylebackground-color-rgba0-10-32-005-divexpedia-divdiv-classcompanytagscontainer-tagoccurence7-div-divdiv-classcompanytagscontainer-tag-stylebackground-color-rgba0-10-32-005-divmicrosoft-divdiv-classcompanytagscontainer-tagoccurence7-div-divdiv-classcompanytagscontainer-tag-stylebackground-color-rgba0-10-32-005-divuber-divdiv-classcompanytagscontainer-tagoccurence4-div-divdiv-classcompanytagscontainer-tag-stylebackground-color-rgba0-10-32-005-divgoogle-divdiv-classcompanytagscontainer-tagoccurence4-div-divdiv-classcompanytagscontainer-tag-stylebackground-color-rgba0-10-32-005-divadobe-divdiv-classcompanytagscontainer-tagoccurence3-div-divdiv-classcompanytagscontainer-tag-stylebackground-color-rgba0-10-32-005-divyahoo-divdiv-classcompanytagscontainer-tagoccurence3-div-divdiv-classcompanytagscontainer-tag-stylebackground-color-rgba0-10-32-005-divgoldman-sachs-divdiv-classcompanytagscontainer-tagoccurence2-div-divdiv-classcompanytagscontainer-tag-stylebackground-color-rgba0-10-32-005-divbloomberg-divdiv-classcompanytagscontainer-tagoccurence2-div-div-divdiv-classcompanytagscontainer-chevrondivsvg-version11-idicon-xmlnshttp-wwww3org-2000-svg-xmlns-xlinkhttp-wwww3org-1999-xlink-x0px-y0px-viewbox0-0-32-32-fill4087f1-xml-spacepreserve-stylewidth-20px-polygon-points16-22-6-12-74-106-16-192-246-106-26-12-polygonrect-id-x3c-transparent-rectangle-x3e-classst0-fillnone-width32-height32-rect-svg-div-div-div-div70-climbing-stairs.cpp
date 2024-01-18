class Solution {
private:
    int f(int n, vector<int> &dp) {
        if(n <= 1) return 1;
        if(dp[n] != -1) {
            return dp[n];
        }
        int oneJump = f(n - 1,dp);
        int twoJump = f(n - 2, dp);
        return dp[n] = oneJump + twoJump;
    }
public:
    int climbStairs(int n) {
        vector<int> dp(n+1,0);
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int oneJump = dp[i - 1];
            int twoJump = dp[i - 2];
            dp[i] = oneJump + twoJump;
        }
        return dp[n];
    }
};