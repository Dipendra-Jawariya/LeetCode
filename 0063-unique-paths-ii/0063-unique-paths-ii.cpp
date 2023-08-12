class Solution {
private:
    int f(int row,int col,vector<vector<int>> &grid,vector<vector<int>> &dp) {
        if(row < 0 || col < 0 || grid[row][col] == 1) return 0;
        if(row == 0 && col == 0) return 1;
        
        if(dp[row][col] != -1) return dp[row][col]; 
        
        int up = f(row-1,col,grid,dp);
        int left = f(row,col-1,grid,dp);
        
        return dp[row][col] = up + left;
    }
public:
    int uniquePathsWithObstacles(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dp(n,vector<int>(m,-1));
        return f(n-1,m-1,grid,dp);
    }
};