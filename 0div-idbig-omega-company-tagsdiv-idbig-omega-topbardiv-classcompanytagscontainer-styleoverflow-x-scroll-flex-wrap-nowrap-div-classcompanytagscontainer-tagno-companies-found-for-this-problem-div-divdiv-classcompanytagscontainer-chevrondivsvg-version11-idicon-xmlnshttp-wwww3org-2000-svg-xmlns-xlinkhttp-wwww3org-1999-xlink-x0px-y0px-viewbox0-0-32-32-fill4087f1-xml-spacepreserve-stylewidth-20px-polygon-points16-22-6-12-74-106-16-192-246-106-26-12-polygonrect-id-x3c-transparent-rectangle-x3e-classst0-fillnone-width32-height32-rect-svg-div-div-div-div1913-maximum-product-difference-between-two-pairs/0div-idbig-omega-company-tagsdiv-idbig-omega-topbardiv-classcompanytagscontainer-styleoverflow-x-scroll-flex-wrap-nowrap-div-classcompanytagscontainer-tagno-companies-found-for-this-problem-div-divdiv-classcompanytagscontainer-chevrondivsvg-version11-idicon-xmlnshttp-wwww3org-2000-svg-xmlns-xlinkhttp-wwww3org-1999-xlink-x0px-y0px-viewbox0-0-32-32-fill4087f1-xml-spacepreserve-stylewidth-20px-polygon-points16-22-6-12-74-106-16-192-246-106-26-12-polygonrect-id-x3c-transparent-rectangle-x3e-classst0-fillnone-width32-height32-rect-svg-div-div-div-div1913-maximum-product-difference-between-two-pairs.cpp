class Solution {
public:
    int maxProductDifference(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        int maxi = nums[n - 1] * nums[n - 2];
        int mini = nums[0] * nums[1];
        return maxi - mini;
    }
};