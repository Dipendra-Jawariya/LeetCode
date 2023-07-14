class Solution {
private:
    int findMax(vector<int> &nums) {
        int maxi = -1e9;
        for(int i = 0; i < nums.size(); i++) {
            maxi = max(maxi,nums[i]);
        }
        return maxi;
    }
private:
    int possible(int divisor,vector<int> &nums, int threshold) {
        int val = 0;
        for(int i = 0; i < nums.size(); i++) {
            val += (ceil)((double) nums[i] / (double)divisor);
        }
        return val <= threshold;
    }
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        int n = nums.size();
        int low = 1, high = findMax(nums);
        
//         for(int i = low; i <= high; i++) {
            
//             if(possible(i,nums,threshold)) {
//                 return i;
//             }
//         }
//         return high;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(possible(mid,nums,threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};