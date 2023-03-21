class Solution {
private:
    void dfs(int row,int col, int initial_color,int newColor,vector<vector<int>>& ans,
        vector<vector<int>>& image,int delRow[],int delCol[]) {
        ans[row][col] = newColor;
        int n = image.size();
        int m = image[0].size();
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
            image[nrow][ncol] == initial_color && ans[nrow][ncol] != newColor) {
                dfs(nrow,ncol,initial_color,newColor,ans,image,delRow,delCol);
            }
        }
    }
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int initial_color = image[sr][sc];
        vector<vector<int>> ans = image;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        dfs(sr,sc,initial_color,newColor,ans,image,delRow,delCol);
        return ans;
    }
};