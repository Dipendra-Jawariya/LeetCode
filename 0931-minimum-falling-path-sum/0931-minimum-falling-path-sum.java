class Solution {
    private int getMaxSum(int i,int j ,int m,int matrix[][],int dp[][]){
    // Base Case
        if(j < 0 || j >= m) return (int) Math.pow(10,9);
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up = matrix[i][j] + getMaxSum(i-1,j,m,matrix,dp);
        int leftDia = matrix[i][j] + getMaxSum(i-1,j-1,m,matrix,dp);
        int rightDia = matrix[i][j] + getMaxSum(i-1,j+1,m,matrix,dp);
        return dp[i][j] = Math.min(up,Math.min(leftDia,rightDia));
    }
   
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxi = Integer.MAX_VALUE;
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,0);
        }
        for(int j = 0; j < m; j++){
            dp[0][j] = matrix[0][j];
            // int ans = getMaxSum(n-1,j,m,matrix,dp);
            // maxi = Math.min(maxi,ans);
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i-1][j];
                int leftDia = (int) 1e9;
                if(j-1 >= 0) {
                   leftDia =  matrix[i][j] + dp[i-1][j-1];   
                }
                
                int rightDia = (int) 1e9;
                if(j+1 < m) {
                   rightDia = matrix[i][j] + dp[i-1][j+1];   
                }
                dp[i][j] = Math.min(up,Math.min(leftDia,rightDia));
            }
        }
        maxi = dp[n-1][0];
        for(int j = 1; j < m; j++) {
            maxi = Math.min(dp[n-1][j],maxi);
        }
        return maxi;
    }
} 