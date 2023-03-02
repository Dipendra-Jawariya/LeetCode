class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n,1),hash(n);
        
        int maxi = 1;
        int lastIndex = 0;
        for(int ind = 0; ind < n; ind++) {
            hash[ind] = ind;
            for(int prev= 0; prev < ind; prev++) {
                if(nums[prev] < nums[ind] && 1 + dp[prev] > dp[ind]) {
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                    
                }
            }
            if(dp[ind] > maxi) {
                maxi = dp[ind];
                lastIndex = ind;
            }
        }
       vector<int> temp;
        temp.push_back(nums[lastIndex]);
        // lis[0] = arr[lastIndex
        int ind = 1;
        while(hash[lastIndex] != lastIndex ) {
            lastIndex = hash[lastIndex];
            temp.push_back(nums[lastIndex]);
        }
        reverse(temp.begin(),temp.end());
        for(auto it : temp) cout << it << " ";
        return maxi;
    }
};