class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int totalSum = accumulate(nums.begin(),nums.end(), 0);
        int target = totalSum - x;
        
        if(target < 0) {
            return -1;
        }
        if(target == 0) {
            return nums.size();
        }
        int n = nums.size();
        int operations = 1e9;
        int sum = 0;
        int left = 0, right = 0;
        
        while(right < n) {
            sum += nums[right++];
            
            while(sum > target && left < n) {
                sum -= nums[left++];
            }
            if(sum == target) {
                operations = min(operations,n - (right - left));
            }
        }
        return (operations == 1e9) ? -1 : operations;
    }
}; 