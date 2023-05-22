class Solution {
private:
    int f(int i,int j, vector<vector<int>>& tri, vector<vector<int>>& dp) {
        if( i == tri.size()-1) return tri[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int down = tri[i][j] + f(i+1,j,tri,dp);
        int diag = tri[i][j] + f(i+1,j+1,tri,dp);
        return dp[i][j] = min(down, diag);
    }
public:
    int minimumTotal(vector<vector<int>>& tri) {
        int n = tri.size();
        vector<vector<int>> dp(n,vector<int>(n,0));
        for(int j = 0 ; j < n; j++) {
            dp[n-1][j] = tri[n-1][j];
        }
        for(int i = n-2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int down = tri[i][j] + dp[i+1][j];
                int diag = tri[i][j] + dp[i+1][j+1];
                dp[i][j] = min(down,diag);
            }
        }
        return dp[0][0];
    }
};