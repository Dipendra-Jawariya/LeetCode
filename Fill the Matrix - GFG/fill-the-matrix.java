//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java
class Pair{
    int steps;
    int row;
    int col;
    Pair(int steps,int row ,int col) {
        this.steps = steps;
        this.row = row;
        this.col = col;
    }
}
class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//Bfs
// 		if(N == x && M == y) {
// 		    return 0;
// 		}
		int vis[][] = new int[N][M];
		for(int it[] : vis) Arrays.fill(it,0);
		vis[x-1][y-1] = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,x-1,y-1));
		
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        int maxi = 0;
        while(!q.isEmpty()) {
            Pair it = q.peek();
            q.remove();
            int steps = it.steps;
            int row = it.row;
            int col = it.col;
            // System.out.println(steps);
            maxi = Math.max(maxi,steps);
            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >=0 && nrow < N && ncol >= 0 && ncol < M && 
                vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(steps + 1,nrow,ncol));
                }
            }
        }
        return maxi;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends