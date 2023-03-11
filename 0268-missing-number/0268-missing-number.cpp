class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int num = 0;
        for(auto it : nums) {
            if(it != num) {
                return num;
            }
            ++num;
        }
        return num;
    }
};