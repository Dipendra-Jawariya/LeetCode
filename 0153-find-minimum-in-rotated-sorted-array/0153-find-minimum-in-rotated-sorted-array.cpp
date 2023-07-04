class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int mini = 1e9;
        int low = 0 , high = n - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2; 
            
            if(nums[low] <= nums[mid]) {
                mini = min(mini,nums[low]);
                low  = mid + 1;
            }else {
                high = mid - 1;
                mini = min(mini,nums[mid]);
            }
        }
        return mini;
    }
};