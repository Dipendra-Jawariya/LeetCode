//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int f(int ind,int last,int color[][], int dp[][]) {
        if(ind == 0) {
            int mini = (int) 1e9;
            for(int i = 0; i < 3; i++){
                if(i != last){
                    mini = Math.min(mini , color[ind][i]);
                }
            }
            return  mini;
        }
        if(dp[ind][last] != -1 ) return dp[ind][last]; 
        int mini = (int) 1e9;
        for(int i = 0; i < 3; i++) {
            if( i != last) {
                int cost  = color[ind][i] + f(ind - 1, i, color,dp);
                mini = Math.min(mini , cost);
            }
        }
        return dp[ind][last] = mini;
    }
	int minCost(int [][] colors, int N){
	    int dp[][] = new int[N][4];
	    for(int it[] : dp) {
	       Arrays.fill(it,-1);
	    }
	    return f(N - 1,3,colors,dp);
    }
}