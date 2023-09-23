class Solution {
private:
    int f(int ind,int n,int prev,vector<int> &nums,vector<vector<int>> &dp) {
        if(ind == n) {
            return 0;
        }
        if(dp[ind][prev + 1] != -1) {
            return dp[ind][prev + 1];
        }
        int pick = INT_MIN;
        if(prev == -1 || nums[prev] < nums[ind]) {
            pick = 1 + f(ind+1,n,ind,nums,dp);
        }
        int notPick = f(ind +1, n, prev,nums,dp);
        return dp[ind][prev + 1] = max(pick ,notPick);
    }
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n,vector<int> (n+1,-1));
        return f(0,n,-1,nums,dp);
    }
};