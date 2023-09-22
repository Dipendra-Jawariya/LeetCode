class Solution {
private:
    void bfs(int sr,int sc,int initialColor,int color,vector<vector<int>>& image,
             vector<vector<int>>& ans) {
        queue<pair<int,int>> q;
        q.push({sr,sc});
        
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        
        int n = image.size();
        int m = image[0].size();
        while(!q.empty()) {
            int row = q.front().first;
            int col = q.front().second;
            q.pop();
            
            ans[row][col] = color;
            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                   image[nrow][ncol] == initialColor && ans[nrow][ncol] != color) {
                    q.push({nrow,ncol});
                }
            }
        }
    }

private:
    void dfs(int row,int col,int initialColor,int color,vector<vector<int>>& image,
             vector<vector<int>>& ans) {
        ans[row][col] = color;
        int n = image.size();
        int m = image[0].size();
        
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                   image[nrow][ncol] == initialColor && ans[nrow][ncol] != color) {
                    dfs(nrow,ncol,initialColor,color,image,ans);
            }
        }
    }
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        vector<vector<int>> ans = image;
        dfs(sr,sc,initialColor,color,image,ans);
        return ans;
    }
};