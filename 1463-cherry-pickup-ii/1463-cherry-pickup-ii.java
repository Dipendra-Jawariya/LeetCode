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
        int r = grid.length;
        int c = grid[0].length;
        int dp[][][] = new int[r][c][c];
        for(int rows[][]: dp){
            for(int row[] :rows){
                Arrays.fill(row, -1);
            }
        }
        return recMemo(0,0,c-1,r,c,grid,dp);
    }
} 