class Solution {
private:
    int firstOccurence(vector<int> & nums,int target,int n) {
        int low = 0,high = n - 1;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
private:
    int lastOccurence(vector<int> &nums,int target,int n ) {
        int low = 0, high = n - 1;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if(nums[mid] < target) {
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
        int n = nums.size();
        int frst = firstOccurence(nums,target,n);
        if(frst == -1 ) return {-1,-1};
        int lst = lastOccurence(nums,target,n);
        return {frst,lst};
    }
};