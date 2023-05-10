class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        //  int n = mat.size();
        // int m = mat[0].size();
        int left = 0, right = n-1;
        int top = 0 , bottom = n-1;
        int num = 1;

        vector<vector<int>> ans(n,vector<int>(n));

        while(top <= bottom && left <= right) {
            // right 
            for(int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                ans[i][right] = num++;;
            }
            right--;
            if(top <= bottom ) {
              for (int i = right; i >= left; i--) {
                ans[bottom][i] = num++;
              }
            }
            bottom--;
            if(left <= right) {
              for (int i = bottom; i >= top; i--) {
                ans[i][left] = num++;
              }
            }
            left++;
        }
        return ans;
    }   
};