class Solution {
private:
    void dfs(int row,int col,vector<vector<int>>& grid,
             vector<vector<int>>& vis,vector<int> delRow,
             vector<int> delCol) {
        vis[row][col] = 1;
        
        int n = grid.size();
        int m = grid[0].size();
        
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
               vis[nrow][ncol] == 0 && grid[nrow][ncol] == 0) {
                dfs(nrow,ncol,grid,vis,delRow,delCol);
            }
        }
    }
    
public:
    int closedIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        vector<int> delRow = {-1,0,1,0};
        vector<int> delCol = {0,1,0,-1};
        
        for(int j = 0; j < m; j++) {
            if(vis[0][j] == 0 && grid[0][j] == 0) {
                dfs(0,j,grid,vis,delRow,delCol);    
            }
            if(vis[n-1][j] == 0 && grid[n-1][j] == 0) {
                dfs(n-1, j, grid,vis,delRow,delCol);
            }
        }
        
        for(int i = 0;i < n; i++) {
            if(vis[i][0] == 0 && grid[i][0] == 0) {
                dfs(i,0,grid,vis,delRow,delCol);
            }
            if(vis[i][m-1] == 0 && grid[i][m-1] == 0) {
                dfs(i,m-1,grid,vis,delRow,delCol);
            }
        }
        
        int cntcon_grp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 0) {
                    cntcon_grp++;
                    dfs(i,j,grid,vis,delRow,delCol);
                }
            }
        }
        return cntcon_grp++;
    }
};