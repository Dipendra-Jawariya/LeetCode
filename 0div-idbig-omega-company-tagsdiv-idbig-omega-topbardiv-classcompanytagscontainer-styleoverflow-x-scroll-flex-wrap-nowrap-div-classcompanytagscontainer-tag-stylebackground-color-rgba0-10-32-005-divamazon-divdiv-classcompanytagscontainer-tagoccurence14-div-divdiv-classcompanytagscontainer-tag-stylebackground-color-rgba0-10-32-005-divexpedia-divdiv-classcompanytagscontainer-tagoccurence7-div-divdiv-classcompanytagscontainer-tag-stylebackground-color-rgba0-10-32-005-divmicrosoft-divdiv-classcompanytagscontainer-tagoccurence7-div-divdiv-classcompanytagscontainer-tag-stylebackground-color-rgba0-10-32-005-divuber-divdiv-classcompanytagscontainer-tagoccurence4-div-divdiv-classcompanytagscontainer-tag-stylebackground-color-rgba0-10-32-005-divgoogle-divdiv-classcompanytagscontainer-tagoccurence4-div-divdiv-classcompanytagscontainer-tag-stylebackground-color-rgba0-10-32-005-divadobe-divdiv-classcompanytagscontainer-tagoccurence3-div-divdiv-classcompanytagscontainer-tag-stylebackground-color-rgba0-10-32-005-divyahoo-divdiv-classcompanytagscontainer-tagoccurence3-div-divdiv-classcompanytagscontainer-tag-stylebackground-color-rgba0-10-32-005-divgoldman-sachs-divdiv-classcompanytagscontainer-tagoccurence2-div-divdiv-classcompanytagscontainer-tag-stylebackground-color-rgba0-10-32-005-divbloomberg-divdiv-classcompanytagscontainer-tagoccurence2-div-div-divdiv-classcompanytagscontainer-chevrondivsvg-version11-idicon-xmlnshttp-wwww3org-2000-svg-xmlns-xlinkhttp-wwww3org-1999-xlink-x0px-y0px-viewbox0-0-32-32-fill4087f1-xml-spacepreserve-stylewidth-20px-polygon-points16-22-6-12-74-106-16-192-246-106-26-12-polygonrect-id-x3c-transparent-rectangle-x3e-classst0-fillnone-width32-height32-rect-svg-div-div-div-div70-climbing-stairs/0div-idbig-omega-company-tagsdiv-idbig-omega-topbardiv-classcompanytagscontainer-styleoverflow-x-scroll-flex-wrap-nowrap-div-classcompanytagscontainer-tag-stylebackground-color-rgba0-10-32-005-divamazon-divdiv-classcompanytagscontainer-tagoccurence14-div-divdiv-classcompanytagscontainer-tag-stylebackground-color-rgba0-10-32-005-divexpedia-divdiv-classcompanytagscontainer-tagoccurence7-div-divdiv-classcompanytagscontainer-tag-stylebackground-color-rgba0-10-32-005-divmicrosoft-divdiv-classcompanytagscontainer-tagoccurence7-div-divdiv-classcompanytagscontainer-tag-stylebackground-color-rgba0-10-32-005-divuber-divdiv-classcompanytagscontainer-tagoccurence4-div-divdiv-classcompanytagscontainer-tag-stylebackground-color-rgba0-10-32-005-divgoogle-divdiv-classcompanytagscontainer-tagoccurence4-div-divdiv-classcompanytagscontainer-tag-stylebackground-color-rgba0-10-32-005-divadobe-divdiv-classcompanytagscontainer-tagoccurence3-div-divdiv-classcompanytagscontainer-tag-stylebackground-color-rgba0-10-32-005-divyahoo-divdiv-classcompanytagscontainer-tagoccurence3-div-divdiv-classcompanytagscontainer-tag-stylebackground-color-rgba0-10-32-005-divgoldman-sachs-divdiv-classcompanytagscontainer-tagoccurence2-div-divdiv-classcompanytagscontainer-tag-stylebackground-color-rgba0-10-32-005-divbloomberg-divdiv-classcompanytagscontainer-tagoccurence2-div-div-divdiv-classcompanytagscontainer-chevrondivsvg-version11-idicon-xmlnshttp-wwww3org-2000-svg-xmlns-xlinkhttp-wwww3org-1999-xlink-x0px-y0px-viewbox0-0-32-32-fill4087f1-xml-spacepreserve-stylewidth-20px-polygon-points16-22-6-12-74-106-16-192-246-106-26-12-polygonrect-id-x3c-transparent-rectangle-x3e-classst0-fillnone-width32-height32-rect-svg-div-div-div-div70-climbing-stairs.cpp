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
        vector<int> dp(n+1,-1);
        return f(n,dp);
    }
};