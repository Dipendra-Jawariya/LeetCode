class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int mini = 1e9;
        int low = 0 , high = n - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2; 
            
            if(nums[mid] <= mini) mini = nums[mid];
            
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){ 
                low ++;
                high--; 
                continue;
            }
            
            if(nums[low] >= nums[mid]) {
                if(nums[mid] <= nums[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(nums[low] <= nums[mid] && nums[low] < nums[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;  
                }
            }
        }
        return mini;
    }
};