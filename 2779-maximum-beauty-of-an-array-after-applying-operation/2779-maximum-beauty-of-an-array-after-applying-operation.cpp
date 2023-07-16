class Solution {
public:
    int maximumBeauty(vector<int>& nums, int k) {
        int n = nums.size();
        sort(nums.begin(),nums.end());
        int ans = 0;
        int j = 0;
        for(int i = 0;  i < n; i++) {
            if(nums[i] - nums[j] > 2 * k) {
                j++;
            } else  ans = max(ans,i - j + 1);
        }
        return ans;
    }
};