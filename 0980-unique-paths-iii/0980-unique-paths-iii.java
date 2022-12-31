class Solution {
    private int rec(int x,int y, int grid[][],int zero){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1){
            return 0;
        }
        if(grid[x][y] == 2) return zero == -1?1:0;
        grid[x][y] = -1;
        zero--;
        int up = rec(x-1,y,grid,zero);
        int down = rec(x+1,y,grid,zero);
        int left = rec(x,y-1,grid,zero);
        int right = rec(x,y+1,grid,zero);
        grid[x][y] = 0;
        zero++;
        return (up+down+left+right);
    }
    public int uniquePathsIII(int[][] grid) {
        int r = grid.length;
        int c= grid[0].length;
        int sx = 0, sy = 0,zero = 0;
        for(int i =0;i< r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 0) {
                    zero++;
                }else if(grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }
            }
        }
        return rec(sx,sy,grid,zero);
    }
}