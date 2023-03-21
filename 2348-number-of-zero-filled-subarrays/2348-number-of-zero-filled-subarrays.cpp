class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        int n = nums.size();
        long long subarray = 0;
        long long ans = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                subarray += 1;
            } else {
                subarray = 0;
            }
            ans += subarray;
        }
        return ans;
    }
};