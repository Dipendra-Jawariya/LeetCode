class Solution {
private:
    int func(vector<int>& nums, int maxsum) {
        int split = 1, sum = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(sum + nums[i] <= maxsum) {
                sum += nums[i];
            } else {
                split++;
                sum = nums[i];
            }
        }
        return split;
    }
public:
    int splitArray(vector<int>& nums, int k) {
        int low  = *max_element(nums.begin(),nums.end());
        int high = accumulate(nums.begin(),nums.end(),0);
        
        // for(int curr = low; curr <= high; curr++) {
        //     int noOfSplit = func(nums,curr);
        //     if(noOfSplit == k) {
        //         return curr;
        //     }
        // }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int noOfSplit = func(nums,mid);
            if(noOfSplit > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
};