class Solution {
public:
    int arraySign(vector<int>& nums) {
        int n = nums.size();
        int pos = 0 , neg = 0;
        for(int i = 0; i < n; i++) {
            if( nums[i] == 0) return 0;
            if(nums[i] < 0) {
                neg++;
            }
        }
        return neg % 2 == 0 ? 1 : -1;
    }
};