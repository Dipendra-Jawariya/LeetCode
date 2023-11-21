class Solution {
private:
    int rev(int num) {
        int curr_num = 0;
        while(num > 0) {
            int rem = num % 10;
            curr_num = curr_num * 10 + rem;
            num = num / 10;
        }
        
        return curr_num;
    }
public:
    int countNicePairs(vector<int>& nums) {
        int n = nums.size();
        vector<int> arr;
        for(int i = 0; i < n; i++) {
            arr.push_back(nums[i] - rev(nums[i]));
        }
        
        unordered_map<int,int> mpp;
        int ans = 0;
        int mod = 1e9 + 7;
        for(int num : arr) {
            ans = (ans + mpp[num]) % mod;
            mpp[num]++;
        }
        return ans;
    }
};