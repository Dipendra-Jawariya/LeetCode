class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        int mod = 1e9 + 7;
        
        int n = nums.size();
        int ans = 0;
        vector<int>pow(n,1);
        int low = 0, high = n-1;
        for(int i = 1; i < n; i++) {
            pow[i] = (pow[i-1]*2) % mod;
        }
        
        while(low <= high) {
            if(nums[low] + nums[high] > target) {
                high--;
            } else {
                ans = (ans + pow[high-low]) % mod;
                low++;
            }
        }
        return ans;
    }
};