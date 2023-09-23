class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int vis[n][m];
        
        queue<pair<pair<int,int>,int>> q;
        int fresh_oranges = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.push({{i,j},0});
                } else {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) {
                    fresh_oranges++;
                }
            }
        }
        int req_time = 0;
        
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, 1, 0, -1};
        
        while(!q.empty()) {
            int row = q.front().first.first;
            int col = q.front().first.second;
            int time = q.front().second;
            q.pop();
            req_time = max(req_time, time);
            
            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 
                   && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 2;
                    q.push({{nrow,ncol},time+1});
                    fresh_oranges--;
                }
            }
        }
        
        if(fresh_oranges == 0) {
            return req_time;
        } else return -1;
    }
}; 