class Solution {
private:
    int f(int n,int m, vector<vector<int>> &dp) {
        if(n == 0 && m == 0) {
            return 1;
        }
        if(n < 0 || m < 0) {
            return 0;
        }
        if(dp[n][m] != -1) return dp[n][m];
        int up = f(n-1,m,dp);
        int left = f(n,m-1,dp);
        return dp[n][m] = up + left;
    }
public:
    int uniquePaths(int m, int n) {
        // vector<vector<int>> dp(n,vector<int>(m,0));
        vector<int> prev(m,0);
        vector<int> curr(m,0);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if( i == 0 && j == 0) {
                    curr[j] = 1;
                } else {
                    int up = 0;
                    if(i > 0) {
                        up = prev[j];    
                    }
                    int left = 0;
                    if(j > 0) {
                        left = curr[j-1];
                    }
                    curr[j] = up + left;    
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }
};