class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        vector<int> ans;
        bool up = true;
        
        int row = 0 , col = 0;
        while(row < m && col < n) {
            if(up) {
                while(row > 0 && col < n - 1) {
                    ans.push_back(mat[row][col]);
                    row--;
                    col++;
                }
                ans.push_back(mat[row][col]);
                if(col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while(row < m -1 && col > 0) {
                    ans.push_back(mat[row][col]);
                    col--;
                    row++;
                }
                ans.push_back(mat[row][col]);
                if(row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            up = !up;
        }
        return ans;
    }
};