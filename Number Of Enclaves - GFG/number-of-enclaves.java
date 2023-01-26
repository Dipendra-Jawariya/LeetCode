//{ Driver Code Starts
// Initial Template for Java

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

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {

    int numberOfEnclaves(int[][] grid) {

        //bfs
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        
        // int delRow[] = {-1,0,1,-1};
        // int delCol[] = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && grid[i][0] == 1){
                vis[i][0] = 1;
                q.add(new Pair(i,0));
            }
            if(vis[i][m-1] == 0 && grid[i][m-1] == 1){
                vis[i][m-1] = 1;
                q.add(new Pair(i,m-1));
            }
        }
        for(int j = 0; j < m; j++){
                if(vis[0][j] == 0 && grid[0][j] == 1){
                    vis[0][j] = 1;
                    q.add(new Pair(0,j));
                }
                if(vis[n-1][j] == 0 && grid[n-1][j] == 1){
                    vis[n-1][j] = 1;
                    q.add(new Pair(n-1,j));
                }
        }
        
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        //traverse the connected component
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            for(int i = 0;i <4;i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                //validity check
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 &&
                grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int cnt = 0;
        //now compare and count the not visisted ones 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}