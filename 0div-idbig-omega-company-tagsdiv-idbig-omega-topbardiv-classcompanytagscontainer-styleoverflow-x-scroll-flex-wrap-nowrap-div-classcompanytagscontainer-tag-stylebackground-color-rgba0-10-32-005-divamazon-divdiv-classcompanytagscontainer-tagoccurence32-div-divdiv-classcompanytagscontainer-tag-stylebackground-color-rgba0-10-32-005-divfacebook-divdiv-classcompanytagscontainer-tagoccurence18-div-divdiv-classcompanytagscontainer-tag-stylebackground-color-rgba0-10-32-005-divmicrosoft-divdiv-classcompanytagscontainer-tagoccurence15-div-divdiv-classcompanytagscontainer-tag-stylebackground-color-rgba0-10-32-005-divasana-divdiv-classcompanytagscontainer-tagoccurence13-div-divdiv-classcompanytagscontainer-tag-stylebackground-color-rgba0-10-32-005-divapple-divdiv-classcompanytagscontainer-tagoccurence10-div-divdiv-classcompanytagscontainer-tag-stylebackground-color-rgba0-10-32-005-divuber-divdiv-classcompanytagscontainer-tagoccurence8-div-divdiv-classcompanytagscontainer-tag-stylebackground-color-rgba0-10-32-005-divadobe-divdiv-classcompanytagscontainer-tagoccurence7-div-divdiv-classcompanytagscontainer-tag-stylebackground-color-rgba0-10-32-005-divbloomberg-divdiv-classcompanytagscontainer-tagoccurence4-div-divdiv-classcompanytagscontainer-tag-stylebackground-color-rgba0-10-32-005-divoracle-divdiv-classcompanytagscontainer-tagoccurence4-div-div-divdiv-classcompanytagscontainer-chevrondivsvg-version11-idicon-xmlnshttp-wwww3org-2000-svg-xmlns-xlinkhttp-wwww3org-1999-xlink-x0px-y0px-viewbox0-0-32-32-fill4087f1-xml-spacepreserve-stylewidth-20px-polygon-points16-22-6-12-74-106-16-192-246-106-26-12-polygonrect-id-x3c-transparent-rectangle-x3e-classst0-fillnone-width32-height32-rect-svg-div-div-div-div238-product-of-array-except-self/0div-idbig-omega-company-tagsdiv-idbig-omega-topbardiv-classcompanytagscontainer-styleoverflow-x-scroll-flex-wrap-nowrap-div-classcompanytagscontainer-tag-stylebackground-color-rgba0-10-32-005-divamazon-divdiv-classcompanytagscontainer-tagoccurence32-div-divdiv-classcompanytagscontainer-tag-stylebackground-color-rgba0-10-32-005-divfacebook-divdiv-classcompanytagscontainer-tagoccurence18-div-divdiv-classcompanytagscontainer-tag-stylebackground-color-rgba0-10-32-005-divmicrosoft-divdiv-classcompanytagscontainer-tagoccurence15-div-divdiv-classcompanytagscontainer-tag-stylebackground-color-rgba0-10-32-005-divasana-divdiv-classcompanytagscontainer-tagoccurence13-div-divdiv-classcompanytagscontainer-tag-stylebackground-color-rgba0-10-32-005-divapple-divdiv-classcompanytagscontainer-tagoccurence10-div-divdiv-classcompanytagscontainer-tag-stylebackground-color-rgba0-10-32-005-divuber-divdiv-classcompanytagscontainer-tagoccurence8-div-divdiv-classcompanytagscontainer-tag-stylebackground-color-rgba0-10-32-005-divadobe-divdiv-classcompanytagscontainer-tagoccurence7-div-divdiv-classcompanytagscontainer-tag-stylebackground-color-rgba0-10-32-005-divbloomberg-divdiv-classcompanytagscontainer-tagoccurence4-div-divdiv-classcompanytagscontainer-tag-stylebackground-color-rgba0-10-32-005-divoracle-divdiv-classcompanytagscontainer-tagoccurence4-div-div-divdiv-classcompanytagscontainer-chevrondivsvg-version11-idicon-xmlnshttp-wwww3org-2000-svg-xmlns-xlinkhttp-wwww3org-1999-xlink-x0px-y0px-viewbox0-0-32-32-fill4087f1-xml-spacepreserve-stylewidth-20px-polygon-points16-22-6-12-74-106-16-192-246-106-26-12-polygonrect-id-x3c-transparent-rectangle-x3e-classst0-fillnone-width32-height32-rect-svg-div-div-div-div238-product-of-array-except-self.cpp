class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        for(int i = n - 1; i >= 0; i--) {
            if(i < n - 1) {
                ans[i] = ans[i + 1] * nums[i+1];
            } else {
                ans[i] = 1;
            }
        }
        int left = 1;
        for(int i = 0; i < n; i++) {
            ans[i] = left * ans[i];
            left *= nums[i];
        }
        return ans;
    }
};