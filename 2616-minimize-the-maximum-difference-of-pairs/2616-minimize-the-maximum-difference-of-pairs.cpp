class Solution {
private:
    bool isPossible(vector<int> &nums,int pair,int threshold) {
        int n = nums.size();
        for(int i = 1; i < n; i++) {
            if(nums[i] - nums[i - 1] <= threshold) {
                pair--;
                i++;
            }
        }
        return pair <= 0;
    }
public:
    int minimizeMax(vector<int>& nums, int p) {
        int n = nums.size();
        sort(nums.begin(),nums.end());
        
        int low = 0 , high = nums[n - 1] - nums[0];
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(nums,p,mid)) {
                high = mid  - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};