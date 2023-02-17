//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int dist;
    int row;
    int col;
    Pair(int dist,int row,int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int dis[][] = new int[n][m];
        for(int it[] : dis) Arrays.fill(it,(int)1e9);
        Queue<Pair> q = new LinkedList<>();
        int delRow[] =  {-1,0,1,0 };
        int delCol[] = {0,1,0,-1};
        q.add(new Pair(0,source[0],source[1]));
        dis[source[0]][source[1]] = 0;
        
        while(!q.isEmpty()) {
            int dist = q.peek().dist;
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            
            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(row == destination[0] && col == destination[1]) {
                        return dist;
                }
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m  && 
                grid[nrow][ncol] == 1 && dist + 1 < dis[nrow][ncol]) {
                    
                    dis[nrow][ncol] = 1 + dist;
                    
                    q.add(new Pair(dist + 1, nrow,ncol));
                    
                }
            }
        }
        return -1;
    }
}
