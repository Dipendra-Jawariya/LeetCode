class Solution {
private:
    int f(int target,vector<int> &nums,vector<int> &dp) {
        if(target == 0) {
            return 1;
        }
        if(dp[target] != -1) return dp[target];
        int ans = 0;
        for(auto &it: nums) {
            if(it <= target) {
                ans += f(target - it, nums,dp);
            }
        }
        return dp[target] = ans;
    }
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> dp(target+1,-1);
        return f(target,nums,dp);
    }
};