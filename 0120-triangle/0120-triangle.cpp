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
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        vector<vector<int>> dp(n,vector<int>(n,-1));
        return f(0,0,triangle,dp);
    }
};