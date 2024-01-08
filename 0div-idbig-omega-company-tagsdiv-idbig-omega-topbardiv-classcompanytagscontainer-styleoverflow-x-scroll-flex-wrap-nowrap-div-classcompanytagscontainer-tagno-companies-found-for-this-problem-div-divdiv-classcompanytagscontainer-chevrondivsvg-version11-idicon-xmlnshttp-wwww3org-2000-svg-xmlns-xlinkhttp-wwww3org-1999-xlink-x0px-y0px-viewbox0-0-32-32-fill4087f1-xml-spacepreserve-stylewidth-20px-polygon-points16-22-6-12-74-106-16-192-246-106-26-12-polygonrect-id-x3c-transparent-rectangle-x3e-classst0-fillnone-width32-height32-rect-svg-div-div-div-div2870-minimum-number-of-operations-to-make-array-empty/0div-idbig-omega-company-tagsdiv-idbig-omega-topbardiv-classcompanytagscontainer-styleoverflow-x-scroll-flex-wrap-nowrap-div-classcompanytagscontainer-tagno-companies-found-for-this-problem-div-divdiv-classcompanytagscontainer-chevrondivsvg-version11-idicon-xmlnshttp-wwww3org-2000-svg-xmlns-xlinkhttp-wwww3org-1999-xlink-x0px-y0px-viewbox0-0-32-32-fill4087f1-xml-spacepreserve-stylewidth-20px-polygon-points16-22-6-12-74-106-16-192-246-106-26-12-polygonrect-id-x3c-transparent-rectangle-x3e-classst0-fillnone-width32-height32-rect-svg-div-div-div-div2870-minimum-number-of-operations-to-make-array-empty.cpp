class Solution {
public:
    int minOperations(vector<int>& nums) {
        unordered_map<int,int> mpp;
        for(int num : nums) {
            mpp[num]++;
        }
        int ans = 0;
        for(auto [_,ch] : mpp) {
            if(ch == 1) return -1;
            
            ans += ceil((double) (ch) / 3);
        }
        return ans;
    }
};