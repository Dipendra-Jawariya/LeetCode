class Solution {
    private int solve(int i,int j, int[][] grid,int dp[][]){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i < 0 || j < 0) return (int) 1e9;
        if(dp[i][j] != -1) return dp[i][j];
         int up = grid[i][j] + solve(i-1,j,grid,dp);
         int left =grid[i][j] + solve(i,j-1,grid,dp);   
        return dp[i][j] = Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // int dp[][]  = new int[n][m];
        // for(int row[] :dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve(n - 1,m - 1,grid,dp);
//         Tabulation
//         for(int i=0;i<n;i++){
//             for(int j =0;j<m;j++){
//                 if(i==0 && j==0){
//                     dp[i][j] = grid[i][j];
//                 }
//                 else{
//                     int up =grid[i][j];
//                     int left = grid[i][j];
//                     if(i>0){
                            //REQUIRING PREVIOUS ROW'S J COLUMN
//                          up += dp[i-1][j];
//                     }else{
//                         up += (int) 1e9;
//                     }
//                     if(j>0){
                            //CURRENT ROW  J-1 COLUMN
//                         left += dp[i][j-1];
//                     }else{
//                         left += (int) 1e9; 
//                     }
//                     dp[i][j] = Math.min(up,left);
//                 }
                
//             }
//         } 
//         return dp[n-1][m-1];
        
        
//         SPACE OPTIMIZATION
        int prev[] = new int[m];
        Arrays.fill(prev,0);
//         i = n
        for(int i=0;i<n;i++){
            int curr[] = new int[m];
            // Arrays.fill()
             for(int j =0;j<m;j++){
                 if(i==0 && j==0) curr[j] = grid[i][j];
                 else{
                     int up = grid[i][j];
                     if(i>0) up+= prev[j];
                     else up += 1e9;
                     
                     int left = grid[i][j];
                     if(j>0) left += curr[j-1];
                     else left+= 1e9;
                     
                     curr[j] = Math.min(up,left);
                 }
             }
            prev = curr;
        }
        return prev[m-1];
    }
}