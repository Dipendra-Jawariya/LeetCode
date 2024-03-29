class Solution {
private:
    int f(int i,int j,vector<vector<int>> &matrix,vector<vector<int>> &dp)  {
        if(j < 0  || j >= matrix[0].size()) {
            return 1e9;
        }
        if(i == 0) {
            return matrix[i][j];
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int straight = matrix[i][j] +  f(i - 1, j, matrix, dp);
        int left_diagonal = matrix[i][j] + f( i - 1, j - 1, matrix, dp);
        int right_diagonal = matrix[i][j] + f(i - 1, j + 1, matrix, dp);
        
        return dp[i][j] = min(straight , min(left_diagonal,right_diagonal));
    }
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        // vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<int> prev(n,0);
        vector<int> curr(n,0);
        for(int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        for(int i = 1 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int straight = matrix[i][j] +  prev[j];
                int left_diagonal = matrix[i][j];
                if(j - 1 >= 0) {
                    left_diagonal += prev[j - 1];
                } else {
                    left_diagonal += 1e9;
                }
                
                int right_diagonal = matrix[i][j];
                if(j + 1 < n) {
                    right_diagonal += prev [j + 1];
                }else {
                    right_diagonal += 1e9;
                }
                curr[j] = min(straight , min(left_diagonal,right_diagonal));
            }
            prev = curr;
        }
        int min_sum = 1e9;
        for(int j = 0; j < n; j++) {
            min_sum = min(min_sum,prev[j]);
        }
        return min_sum;
        
    }
}; 