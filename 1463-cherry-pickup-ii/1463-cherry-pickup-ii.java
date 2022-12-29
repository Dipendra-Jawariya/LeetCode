class Solution {
    private int recMemo(int i,int j1,int j2,int r,int c,int grid[][],int dp[][][]){
        if(j1<0 || j2 < 0 || j1 >= c || j2 >= c) return (int) Math.pow(-10,9);
        if(i == r-1){
            if(j1 == j2) return grid[i][j1];
            else{
                 return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
//         Explore all the paths
        int maxi = Integer.MIN_VALUE;
        for(int di = -1; di<= 1; di++){
            for(int dj = -1; dj <= 1; dj++){
                int value = 0;
                if(j1 == j2) value  = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += recMemo(i+1,j1+di,j2+dj,r,c,grid,dp);
                maxi = Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // int dp[][][] = new int[n][m][m];
        // for(int rows[][]: dp){
        //     for(int row[] :rows){
        //         Arrays.fill(row, -1);
        //     }
        // }
        // return recMemo(0,0,c-1,r,c,grid,dp);
        
        // TABULATION
        
        // base case
        int dp[][][]= new int[n][m][m];
        for(int j1 = 0;j1 < m;j1++){
            for(int j2 = 0; j2 <m; j2++){
                if(j1 == j2){
                    dp[n-1][j1][j2] = grid[n-1][j1];
                }else{
                    dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
                }
            }
        }
        for(int i = n -2;i >= 0; i--){
            for(int j1 =0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
//                     Copy paste
                    int maxi = Integer.MIN_VALUE;
                    for(int dj1 = -1; dj1<= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int value = 0;
                            if(j1 == j2) value  = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if(j1 + dj1 >=0 && j1 + dj1< m && j2+ dj2>=0 && j2+dj2 < m)
                                value += dp[i+1][j1+dj1][j2+dj2];
                            else 
                                value = (int) Math.pow(-10,9);
                            maxi = Math.max(maxi,value);
                        }
                    }
                     dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
} 