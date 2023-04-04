//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Node{
    int row;
    int col;
    int dist;
    Node(int row,int col,int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(grid[row][col] == 1) {
                    vis[row][col] = 1;
                    q.add(new Node(row,col,0));
                } else {
                    vis[row][col] = 0;
                }
            }
        }
        int delRow[] = {-1, 0, +1, 0}; 
	    int delCol[] = {0, +1, 0, -1};
	    
        while(!q.isEmpty()) {
           int row = q.peek().row;
           int col = q.peek().col;
           int steps = q.peek().dist;
           q.remove();
           dist[row][col] = steps;
           for(int i = 0; i < 4; i++) {
               int nrow = row + delRow[i];
               int ncol = col + delCol[i];
               if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                   vis[nrow][ncol] = 1;
                   q.add(new Node(nrow,ncol,steps+1));
               }
           }
        }
        return dist;
    }
}