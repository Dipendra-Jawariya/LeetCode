class Solution {
public:
    void sortColors(vector<int>& nums) {
        //DUTCH NATIONAL FLAG ALGORITHM
        int n =  nums.size() - 1;
        int low = 0, mid = 0, high = n;
        while(mid <= high) {
            if(nums[mid] == 0 ) {
                swap( nums[low],nums[mid]);
                mid++;
                low++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums[high],nums[mid]);
                high--;
            }
        }
        
    }
};