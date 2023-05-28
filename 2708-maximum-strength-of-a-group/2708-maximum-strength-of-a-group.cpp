class Solution {
public:
    long long maxStrength(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums[0];
        long long pos = 0;
        long long neg = 0;
        long long zero = 0;
        long long ans = 1;
        sort(nums.begin(),nums.end());
        for(long long i = 0;i < n; i++) {
            if( nums[i] == 0) 
            {
                zero++;
                continue;
            } else if(nums[i] > 0) {
                cout<<ans <<"*"<< nums[i]<<endl;
                ans *= nums[i];
                pos++;
            } else {
                neg++;
            }
        }
        if(pos == 0 && neg == 0 && zero > 0) return 0;
        if( pos==0 && neg == 1 && zero > 0) {
            return 0;
        }
        if(neg % 2 == 0) {
            for(int i = 0; i < neg; i++) {
                ans *= nums[i];
            }
        } else {
            for(long long i = 0; i < neg-1; i++) {
                
                cout<<ans <<"*"<< nums[i]<<endl;
                ans *= nums[i];
            }
        }
        return ans;
    }
};