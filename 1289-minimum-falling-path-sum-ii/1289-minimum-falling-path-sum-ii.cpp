class Solution {
private:
    int f(int ind,int last,vector<vector<int>>& matrix,vector<vector<int>>& dp) {
        if(ind == 0) {
            int mini = 1e9;
            for(int i = 0; i < matrix.size(); i++) {
                if(i != last) {
                    mini  = min(mini,matrix[0][i]);
                }
            }
            return mini;
        }
        if(dp[ind][last] != -1) {
            return dp[ind][last];
        }
        int mini = 1e9;
        for(int i = 0; i < matrix.size(); i++) {
            if(i != last) {
                int curr_sum = matrix[ind][i] + f(ind-1,i,matrix,dp);
                mini = min(mini,curr_sum);
            }
        }
        return dp[ind][last] = mini;
    }
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int mini = 1e9;
        vector<vector<int>> dp(n,vector<int> (n+1,-1));
        for(int j = 0; j < n; j++) {
            int curr_sum = f(n-1,n,matrix,dp);
            mini = min(mini,curr_sum);
        }
        return mini;
    }
};