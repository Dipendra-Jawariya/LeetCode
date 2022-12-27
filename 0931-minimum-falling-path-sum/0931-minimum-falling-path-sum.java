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
            Arrays.fill(row,-1);
        }
        for(int j = 0; j < m; j++){
            int ans = getMaxSum(n-1,j,m,matrix,dp);
            maxi = Math.min(maxi,ans);
        }
        return maxi;
    }
} 