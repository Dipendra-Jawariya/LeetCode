class Pair{
    int row;
    int col;
    int steps;
    Pair(int row,int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1) {
                    vis[i][j] = 1;
                    q.add(new Pair(i,j,0));
                }else{
                    vis[i][j] = 0;
                }
            }
        }
        int maxi = -1;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            q.remove();
            if(steps > maxi) maxi = steps;
            for(int i = 0; i < 4; i++) {
                int nrow = delRow[i] + row;
                int ncol = delCol[i] + col;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return maxi == 0 ? -1 : maxi;
    }
} 