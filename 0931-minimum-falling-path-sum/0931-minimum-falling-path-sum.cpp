class Solution {
private:
    int f(int i,int j,vector<vector<int>>& matrix,vector<vector<int>>& dp) {
        if( j < 0  || j >= matrix[0].size()) return 1e9;
        if(i == 0) return matrix[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int strainght = matrix[i][j] + f(i-1,j,matrix,dp);
        int leftD = matrix[i][j] + f(i-1,j-1,matrix,dp);
        int rightD = matrix[i][j] + f(i-1,j+1,matrix,dp);
        return dp[i][j] = min(strainght,min(leftD,rightD));
    }
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        
        int mini = 1e9;
        for(int j = 0; j < n; j++) {
            vector<vector<int>> dp(n,vector<int> (n,-1));
            int curr_sum = f(n-1,j,matrix,dp);
            mini = min(mini,curr_sum);
        }
        return mini;
    }
};