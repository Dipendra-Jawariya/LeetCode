class Solution {
private:
    int f(int num,vector<int> &dp) {
        if(num == 1) {
            return 1;
        }
        if(num == 3) return 2;
        if(dp[num] != -1) {
            return dp[num];
        }
        int maxProd = 1 * (num-1);
        int prod = 0;
        for(int i = num / 2; i >= 1; i--) {
            prod = i * max(num-i,f(num - i,dp));
            maxProd = max(maxProd,prod);
        }
        return dp[num] = maxProd;
    }
public:
    int integerBreak(int n) {
        vector<int> dp(n+1,-1);
        return f(n,dp);
    }
};