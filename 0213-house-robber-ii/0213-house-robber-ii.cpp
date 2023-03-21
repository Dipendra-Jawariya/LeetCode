class Solution {
private:
    int f(int ind,vector<int>& nums, vector<int>& dp) {
        
        if(ind < 0) return 0;
        if(ind == 0) return nums[ind];
        
        if(dp[ind] != -1) return dp[ind];
        
        int rob = nums[ind] + f(ind-2,nums,dp);
        int notRob = 0 + f(ind-1,nums,dp);
        
        return dp[ind] = max(rob,notRob);
    }
private:
    int solve(int n ,vector<int> & nums) {
        int prev = nums[0];
        int prev2 = 0;
        for(int ind = 1; ind < n; ind++) {
            int rob = nums[ind];
            if(ind > 1) {
                rob += prev2;
            }
            int notRob = 0 + prev;
            
            prev2 = prev;
            prev = max(rob,notRob);
        }
        return prev;
    }
public:
    int rob(vector<int>& nums) {
        int n =  nums.size();
        vector<int> temp1;
        vector<int> temp2;
        
        if(n == 1) return nums[0];
        
        for(int i = 0; i < n; i++) {
            if(i != 0) {
                temp1.push_back(nums[i]);
            }
            if(i != n-1) {
                temp2.push_back(nums[i]);
            }
        }
        n = temp1.size();
        vector<int> dp(n,-1);
        int first = solve(n,temp1);
        int second = solve(n,temp2);
        return max(first,second);
    }
};