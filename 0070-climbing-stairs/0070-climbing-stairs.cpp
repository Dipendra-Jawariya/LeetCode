class Solution {
public:
    int climbStairs(int nStairs) {
//         vector<int> dp(nStairs+1,-1);
//         dp[0] = 1;
//         dp[1] = 1; 
//         for(int i = 2; i <= nStairs; i++) {
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[nStairs];
        
        //space optimization
        int prev1 = 1;
        int prev2 = 1;
        for(int i = 2; i <= nStairs; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
};