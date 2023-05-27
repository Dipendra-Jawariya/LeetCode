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
        
        // vector<vector<int>> dp(n,vector<int> (n+1,0));
        vector<int> prev(n,0);
        vector<int> curr(n,0);
        for(int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }
        for(int i = 1;i < n; i++) {
            for(int j = 0; j < n; j++) {
                int strainght = matrix[i][j] + prev[j];
                int leftD = matrix[i][j];
                if(j - 1 >= 0) {
                  leftD +=  prev[j-1];    
                } else {
                    leftD += 1e9;
                }
                
                int rightD = matrix[i][j];
                if(j+1 < n) {
                    rightD += prev[j+1];
                } else {
                    rightD += 1e9;
                }
                curr[j] = min(strainght,min(leftD,rightD));
            }
            prev = curr;
        }
        
        int mini = 1e9;
        for(int j = 0; j < n; j++) {
            
            mini = min(mini,prev[j]);
        }
        return mini;
    }
};