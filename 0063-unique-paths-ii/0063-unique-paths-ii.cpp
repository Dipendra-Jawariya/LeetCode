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
        // vector<vector<int>> dp(n,vector<int>(m,0));
        vector<int > prev(m,0),curr(m,0);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    curr[j] = 0;
                } else if(i == 0 && j == 0) curr[j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0) {
                        up = prev[j];
                    } 
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