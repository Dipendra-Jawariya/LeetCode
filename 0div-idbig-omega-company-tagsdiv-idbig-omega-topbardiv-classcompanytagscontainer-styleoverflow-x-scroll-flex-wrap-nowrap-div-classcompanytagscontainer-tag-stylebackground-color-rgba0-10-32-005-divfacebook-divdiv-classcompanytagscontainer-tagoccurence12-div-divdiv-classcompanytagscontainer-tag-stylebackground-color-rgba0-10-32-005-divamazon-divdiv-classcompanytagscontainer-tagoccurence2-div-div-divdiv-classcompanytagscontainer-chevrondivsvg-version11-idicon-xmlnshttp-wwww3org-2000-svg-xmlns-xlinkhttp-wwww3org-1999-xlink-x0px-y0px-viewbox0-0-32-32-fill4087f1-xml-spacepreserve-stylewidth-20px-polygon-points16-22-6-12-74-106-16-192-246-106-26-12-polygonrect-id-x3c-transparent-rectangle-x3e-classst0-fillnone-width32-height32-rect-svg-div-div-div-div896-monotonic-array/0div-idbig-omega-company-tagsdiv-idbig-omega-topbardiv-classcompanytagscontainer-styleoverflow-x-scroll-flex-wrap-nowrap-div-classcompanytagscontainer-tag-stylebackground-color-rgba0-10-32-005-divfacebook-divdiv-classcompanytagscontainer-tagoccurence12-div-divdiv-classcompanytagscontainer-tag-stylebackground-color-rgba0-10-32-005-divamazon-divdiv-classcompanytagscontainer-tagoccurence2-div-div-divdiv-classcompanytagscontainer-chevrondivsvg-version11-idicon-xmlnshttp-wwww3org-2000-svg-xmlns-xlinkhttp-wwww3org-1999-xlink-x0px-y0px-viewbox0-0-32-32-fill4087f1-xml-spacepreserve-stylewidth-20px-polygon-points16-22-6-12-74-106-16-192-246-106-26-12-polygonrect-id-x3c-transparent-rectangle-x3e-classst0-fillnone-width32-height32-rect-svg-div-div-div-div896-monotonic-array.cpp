class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        int n = nums.size();
        if(n < 2) return true;
        
        if(nums[0] <= nums[n-1]) { //increasing
            for(int i = 1; i < n; i++) {
                if(nums[i] < nums[i -1] ) {
                    return false;
                }
            }
            return true;
        }
        else { // decreasing
            for(int i =1 ; i < n; i++) {
                if(nums[i] > nums[i-1]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
};