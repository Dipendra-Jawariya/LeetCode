class Solution {
private:
    bool f(int ind,int n,vector<int>&nums,vector<int>&dp) {
        if(ind >= n) return true;
        
        if(dp[ind] != -1) return dp[ind];
        
        //exactly 2 equal elements
        if(ind + 1 < n &&  nums[ind] == nums[ind+1]) {
            if(f(ind+2,n,nums,dp)) return dp[ind] = true;
        } 
        if(ind + 2 < n && nums[ind] == nums[ind+1] && nums[ind] == nums[ind+2]) {
            if(f(ind+3,n,nums,dp)) return dp[ind] = true;
        } 
        if(ind + 2 < n && nums[ind+1] - nums[ind] == 1 && nums[ind+2] - nums[ind+1] == 1) {
            if(f(ind+3,n,nums,dp)) return dp[ind] = true;
        }
        return dp[ind] = false;        
    }
public:
    bool validPartition(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n,-1);
        return f(0,n,nums,dp);
    }
};