class Solution {
private:
    int f(int ind,vector<int> &nums,vector<int> &dp) {
        if(ind < 0) {
            return 0;
        }
        if(dp[ind] != -1) {
            return dp[ind];
        }
        
        int pick = pick = nums[ind] + f(ind - 2, nums,dp);
        
        int notPick = 0 + f(ind -1, nums,dp);
        
        return dp[ind] = max(pick , notPick);
    }
public:
    int rob(vector<int>& nums) {
        int n= nums.size();
        vector<int> dp(n,0);
        dp[0] = nums[0];
        for(int ind = 1; ind < nums.size(); ind++) {
            int pick = nums[ind];
            if(ind > 1) {
                pick += dp[ind - 2];
            }
            int notPick = dp[ind - 1];
            dp[ind] = max(pick , notPick);
        }
        return dp[n-1];
    }
};