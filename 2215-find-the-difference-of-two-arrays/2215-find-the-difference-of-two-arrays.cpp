class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        vector<vector<int>> ans(2);
        set<int> s1,s2;
        for(auto it : nums1) {
            s1.insert(it);
        }
        for(auto it : nums2) {
            s2.insert(it);
        }
        
        for(auto it : s1) {
            if(s2.count(it) == 0) 
                ans[0].push_back(it);
        }
        for(auto it : s2) {
            if(s1.count(it) == 0) {
                ans[1].push_back(it);
            }
        }
        return ans;
    }
};