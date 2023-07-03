class Solution {
private:
    int lowerBound(vector<int> &nums,int target,int n) {
        int low = 0, high = n - 1;
        int ans = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
private:
    int upperBound(vector<int> &nums,int target,int n) {
        int low = 0, high = n - 1;
        int ans = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        int lb = lowerBound(nums,target,n);
        if(lb == n || nums[lb] != target) return {-1,-1};
        
        int up = upperBound(nums,target,n);
        return {lb, up - 1};
    }
};