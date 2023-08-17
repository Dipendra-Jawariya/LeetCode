class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        
        queue<pair<pair<int,int>,int>> q;
        int vis[n][m];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(mat[row][col] == 0) {
                    q.push({{row,col},0});
                    vis[row][col] = 1;
                } else {
                    vis[row][col] = 0;
                }
            }
        }
        vector<vector<int>> ans(n,vector<int>(m,0));
        while(!q.empty()) {
            int row = q.front().first.first;
            int col = q.front().first.second;
            int dist = q.front().second;
            q.pop();
            ans[row][col] = dist;
            int delRow[] = {-1,0,1,0};
            int delCol[] = {0,1,0,-1};
            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.push({{nrow,ncol}, dist+1});
                }
            }
        }
        return ans;
    }
};