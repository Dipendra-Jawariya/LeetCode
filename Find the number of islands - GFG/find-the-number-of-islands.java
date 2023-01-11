//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void bfs(int row,int col,int vis[][],char grid[][]){
        vis[row][col] = 1;
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            int ro = q.peek().first;
            int co = q.peek().second;
            q.remove();
            
            // traverse in the neighbours and mark them if its a land
            for(int delrow = -1 ;delrow <= 1;delrow++){
                for(int delcol = -1;delcol <= 1;delcol++){
                    int nrow = ro + delrow;
                    int ncol = co + delcol;
                    if(nrow >=0 && nrow < n && ncol >= 0 &&  ncol < m &&
                    grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
        
    }
    public int numIslands(char[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int row[] : vis){
            Arrays.fill(row,0);
        }
        int cnt = 0;
        for(int row = 0;row < n; row++){
            for(int col = 0;col < m;col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    cnt+=1;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return cnt;
    }
}