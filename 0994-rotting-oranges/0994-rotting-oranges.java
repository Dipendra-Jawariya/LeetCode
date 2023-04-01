class Pair {
    int row;
    int col;
    int time;
    Pair(int row,int col,int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        //BFS TRAVERSAL
        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
        int vis[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0;j < m; j++) {
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                if(grid[i][j] == 1) {
                    cntFresh++;
                }
                vis[i][j] = 0;
            }
        }
        
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        int tm = 0;
        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            q.remove();
            tm = Math.max(time,tm);
            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m && 
                   grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol,time+1));
                    cntFresh--;
                }
            }
        }
        
        return cntFresh == 0 ? tm : -1;
    }
}