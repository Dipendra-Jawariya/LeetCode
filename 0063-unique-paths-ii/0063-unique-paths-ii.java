class Solution {
    private int func(int i, int j, int[][] mat,int dp[][]){
        if(i>=0 && j>=0 && mat[i][j]== 1) return 0;
        if(i ==0 && j==0 ) return 1;
        if(i<0 || j <0) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = func(i-1,j,mat,dp);
        int left = func(i,j-1,mat,dp);
        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        // return func(n-1,m-1,obstacleGrid,dp);    
        
//         Tabulation
        dp[0][0] = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] =0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                     int up = 0;
                     int left = 0;
                     if(i>0){
                        up = dp[i-1][j];
                     }
                        if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] =  up + left;
                }
            }
        }
        return dp[n-1][m-1];
    }
}