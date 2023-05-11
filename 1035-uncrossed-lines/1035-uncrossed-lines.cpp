class Solution {
private:
    int f(int i,int j,vector<int>& nums1, vector<int>& nums2, vector<vector<int>> &memo) {
        if(i == 0 && j == 0) {
            return nums1[i] == nums2[i] ? 1 : 0;
        }
        if(i < 0 || j < 0) return 0;
        
        if(memo[i][j] != -1) {
             return memo[i][j];
        }
        if(nums1[i] == nums2[j]) {
            return memo[i][j] = 1 + f(i-1,j-1,nums1,nums2,memo);
        }
        return memo[i][j] = max(f(i-1,j,nums1,nums2,memo) , f(i,j-1,nums1,nums2,memo));
    }
public:
    int maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int m = nums2.size();
        vector<vector<int>> memo(n,vector<int>(m,-1));
        return f(n-1,m-1,nums1,nums2,memo);
    }
};