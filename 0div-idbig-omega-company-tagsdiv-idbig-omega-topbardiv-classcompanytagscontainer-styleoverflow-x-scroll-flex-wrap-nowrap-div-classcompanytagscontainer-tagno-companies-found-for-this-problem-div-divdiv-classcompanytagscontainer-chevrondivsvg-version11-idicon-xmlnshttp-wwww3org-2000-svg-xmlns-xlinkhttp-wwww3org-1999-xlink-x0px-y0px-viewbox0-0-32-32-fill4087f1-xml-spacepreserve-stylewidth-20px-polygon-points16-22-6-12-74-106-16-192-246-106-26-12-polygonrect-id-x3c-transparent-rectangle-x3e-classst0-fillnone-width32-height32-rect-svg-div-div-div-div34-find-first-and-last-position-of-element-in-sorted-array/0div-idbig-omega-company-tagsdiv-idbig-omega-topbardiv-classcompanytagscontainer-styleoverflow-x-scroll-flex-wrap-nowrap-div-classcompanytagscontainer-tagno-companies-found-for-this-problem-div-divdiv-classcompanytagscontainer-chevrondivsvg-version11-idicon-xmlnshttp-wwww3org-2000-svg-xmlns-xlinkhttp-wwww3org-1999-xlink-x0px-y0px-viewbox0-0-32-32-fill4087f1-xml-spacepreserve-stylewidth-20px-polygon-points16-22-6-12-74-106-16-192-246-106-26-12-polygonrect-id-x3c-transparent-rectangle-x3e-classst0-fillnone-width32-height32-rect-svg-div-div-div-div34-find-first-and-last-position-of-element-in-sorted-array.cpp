class Solution {
private:
    int firstOccurance(vector<int> &nums,int target) {
        int low = 0, high = nums.size() - 1;
        int ans = -1;
        while(low <= high ) {
            int mid = (low + high) >> 1;
            if(nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } 
            else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
private:
    int lastOccurance(vector<int> &nums,int target) {
        int low = 0, high = nums.size() - 1;
        int ans = -1;
        while(low <= high ) {
            int mid = (low + high) >> 1;
            if(nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } 
            else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        // Plain Binary Search
        int first =  firstOccurance(nums,target);
        if(first == -1) {
            return {-1,-1};
        }
        int last = lastOccurance(nums,target);
        return {first,last};
    }
};