class Pair {
    int row ;
    int col;
    int dist;
    Pair(int row,int col,int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(mat[row][col] == 0) {
                    vis[row][col] = 1;
                    q.add(new Pair(row,col,0));
                } else {
                    vis[row][col] = 0;
                }
            }
        }
        
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};

        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().dist;
            q.remove();
            dist[row][col] = steps;
            
            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0)  {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return dist;
    }
}