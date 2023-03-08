class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        vector<int> temp;
        int n = nums.size();
        for(int i = 0;i < n; i++) {
            if(nums[i] != 0) {
                temp.push_back(nums[i]);
            }
        }
        for(int i = 0; i < temp.size(); i++) {
            nums[i] = temp[i];
        }
        for(int i = temp.size(); i < n; i++) {
            nums[i] = 0;
        }
    }
};