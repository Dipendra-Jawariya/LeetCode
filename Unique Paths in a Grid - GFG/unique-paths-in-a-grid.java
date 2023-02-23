//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod = (int) (1e9 +7);
    static int f(int i,int j,int n,int m ,int grid[][],int dp[][]) {
        if(i >n || j > m || grid[i][j] != 1) return 0;
        if(i == n && j == m) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int down = f(i+1,j,n,m,grid,dp);
        int right = f(i,j+1,n,m,grid,dp);
        return dp[i][j] = (down + right) % mod;
    }
    static int uniquePaths(int n, int m, int[][] grid) {
        // int dp[][] = new int[n][m];
        // for(int it[]: dp) Arrays.fill(it,0);
        int prev[] = new int[m];
        int cur[] = new int[m];
        // dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <m; j++) {
                if(grid[i][j] == 0) cur[j] =0;
                else if(i == 0 && j == 0) {
                    cur[j] = 1;
                }else{
                    int up = 0,left = 0;
                    if(i > 0) up = prev[j] % mod;
                    if(j > 0 ) left = cur[j-1] % mod;
                    cur[j] = (up +left) % mod;
                }
            } prev = cur;
        }
        return prev[m-1] % mod;
    }
};