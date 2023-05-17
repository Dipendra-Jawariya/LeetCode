class Solution {
public:
    int missingNumber(vector<int>& nums) {
       int n = nums.size();
        int sum = n *(n+1) / 2;
        int curr_sum = 0;
        for(auto it : nums) {
            curr_sum += it;
        }
        return sum - curr_sum;
    }
};