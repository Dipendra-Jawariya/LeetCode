class Pair{
    int distance;
    int row;
    int col;
    Pair(int distance,int row,int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        
        while(pq.size() != 0) {
            Pair it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int row = it.row;
            int col = it.col;
            
            if(row == n-1 && col == m - 1) return diff;
            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newEffort = Math.max(
                        Math.abs(heights[row][col] - heights[nrow][ncol]),diff
                    );
                    if(newEffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Pair(newEffort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}