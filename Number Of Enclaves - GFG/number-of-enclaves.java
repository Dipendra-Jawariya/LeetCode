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

class Solution {
    void dfs(int row,int col,int vis[][],int grid[][],int delRow[],int delCol[]){
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i < 4; i++){
            int nrow =  row + delRow[i];
            int ncol = col + delCol[i];
            
            if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 &&
            grid[nrow][ncol] == 1){
                dfs(nrow,ncol,vis,grid,delRow,delCol);
            }
        }
    }
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int row[] : vis) Arrays.fill(row,0);
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        //column
        for(int j = 0; j < m; j++){
            // first column
            if(vis[0][j] == 0 && grid[0][j] == 1){
                dfs(0,j,vis,grid,delRow,delCol);
            }
            //last column
            if(vis[n-1][j] == 0 && grid[n-1][j] == 1){
                dfs(n-1,j,vis,grid,delRow,delCol);
            }
        }
        //row
        for(int i = 0; i < n;i++){
            //first row 
            if(vis[i][0] == 0 && grid[i][0] == 1){
                dfs(i,0,vis,grid,delRow,delCol);
            }
            //last Row
            if(vis[i][m-1] == 0 && grid[i][m-1] == 1){
                dfs(i,m-1,vis,grid,delRow,delCol);
            }
        }
        int cnt = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}