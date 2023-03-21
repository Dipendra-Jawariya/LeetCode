class Solution {
public:
    int rob(vector<int>& nums) {
        int prev2 = 0;
        int prev = nums[0];
        for(int i = 0; i < nums.size(); i++) {
            int notTake = 0 + prev;
            int take = nums[i];
            if(i > 1) {
                take += prev2;
            }
            prev2 = prev;
            prev = max(take , notTake);
        }
        return prev;
    }
};