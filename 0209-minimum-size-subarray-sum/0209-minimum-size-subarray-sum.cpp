class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size();
        int sum = nums[0];
        int left = 0, right = 0;
        int len = INT_MAX;
        while(right < n) {
            while(left <= right && sum >= target) { 
                len = min(len , right - left + 1);
                cout<<"len"<<len<<endl;
                sum -= nums[left];
                left++;
            }
            
            right++;
            if(right < n ) {
                sum += nums[right];
                cout<< sum << endl;
            }
            
        }
        return len == INT_MAX ? 0 : len;
    }
};