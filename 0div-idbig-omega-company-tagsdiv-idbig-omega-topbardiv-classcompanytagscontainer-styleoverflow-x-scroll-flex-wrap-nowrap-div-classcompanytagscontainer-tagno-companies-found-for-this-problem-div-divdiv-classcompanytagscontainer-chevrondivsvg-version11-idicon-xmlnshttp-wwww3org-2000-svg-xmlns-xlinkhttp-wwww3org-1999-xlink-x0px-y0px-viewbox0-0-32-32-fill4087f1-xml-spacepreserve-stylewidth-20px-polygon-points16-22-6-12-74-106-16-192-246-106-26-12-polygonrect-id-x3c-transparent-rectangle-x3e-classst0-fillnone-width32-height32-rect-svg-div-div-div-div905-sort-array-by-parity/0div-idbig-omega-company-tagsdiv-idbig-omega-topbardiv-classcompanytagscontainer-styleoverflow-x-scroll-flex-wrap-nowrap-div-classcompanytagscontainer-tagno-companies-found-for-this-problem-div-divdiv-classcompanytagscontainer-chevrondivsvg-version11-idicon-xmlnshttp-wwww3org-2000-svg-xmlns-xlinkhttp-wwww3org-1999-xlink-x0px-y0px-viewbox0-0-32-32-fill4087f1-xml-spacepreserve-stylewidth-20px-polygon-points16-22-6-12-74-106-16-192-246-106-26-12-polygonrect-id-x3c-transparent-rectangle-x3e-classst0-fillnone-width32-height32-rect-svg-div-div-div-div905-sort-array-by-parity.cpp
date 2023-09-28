class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 1) {
                for(int j = i + 1; j < n; j++) {
                    if(nums[j] % 2 == 0) {
                        swap(nums[i],nums[j]);
                        break;
                    }
                }
            }
        }
        return nums;
    }
};