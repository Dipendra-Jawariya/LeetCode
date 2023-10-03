class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        
        // Time complexity: O(n)
        // Space complexity: O(n)
        
        int n = nums.size();
        int ans = 0;
        unordered_map<int,int> mpp;
        for(int num : nums) {
            ans += mpp[num];
            mpp[num]++;
        }
        return ans;
    }
};