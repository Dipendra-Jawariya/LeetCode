class Solution {
public:
    long long minCost(vector<int>& nums, int x) {
        int n = nums.size();
        vector<int > cnum(nums.begin(),nums.end());
        for(int it : nums) cnum.push_back(it);
        //[20 1 15 20 1 15]
        long long ans = LONG_MAX;
        vector<int> checked(n,INT_MAX);
        for(int rot = 0; rot < n; rot++) {
            long long sum = 0;
            for(int j = 0; j < n; j++) {
                if(checked[j] > cnum[rot+j]) {
                    checked[j] = cnum[rot+j];
                }
                sum += checked[j];
            }
            sum += (long long) rot * (long long) x;
                
            ans = min(ans,sum);
        }
        return ans;
    }
};