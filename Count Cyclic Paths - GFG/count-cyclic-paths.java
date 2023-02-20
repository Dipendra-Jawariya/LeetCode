//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    static int mod = (int) 1e9 + 7;
    private static int f(int n,char ch,int dp[][]) {
        if(n == 0 && ch == 'o') return 1;
        if(n == 0 && ch != 'o') return 0;
        int ans = 0;
        if(ch == 'o') {
            if(dp[n][0] != -1)  return dp[n][0];
             ans = (ans + f(n-1,'a',dp)) % mod;
             ans = (ans + f(n-1,'b',dp)) % mod;
             ans = (ans + f(n-1,'c',dp)) % mod;
             
             return dp[n][0] = ans;
        }
        if(ch == 'a') {
            if(dp[n][1] != -1)  return dp[n][1];
             ans = (ans + f(n-1,'o',dp)) % mod;
             ans = (ans + f(n-1,'b',dp)) % mod;
             ans = (ans + f(n-1,'c',dp)) % mod;
             
             return dp[n][1] = ans;
        }
        
        if(ch == 'b') {
            if(dp[n][2] != -1)  return dp[n][2];
             ans = (ans + f(n-1,'a',dp)) % mod;
             ans = (ans + f(n-1,'o',dp)) % mod;
             ans = (ans + f(n-1,'c',dp)) % mod;
             
             return dp[n][2] = ans;
        }
        if(ch == 'c') {
            if(dp[n][3] != -1)  return dp[n][3];
             ans = (ans + f(n-1,'a',dp)) % mod;
             ans = (ans + f(n-1,'b',dp)) % mod;
             ans = (ans + f(n-1,'o',dp)) % mod;
             
             return dp[n][3] = ans;
        }
        return ans;
    }
	public static int countPaths(int n){
	    int dp[][] = new int[4][n+1];
	    for(int it[] : dp) {
	        Arrays.fill(it,0);
	    }
	    dp[0][0] = 1;
	    for(int i = 1; i <= n; i++) {
	        for(int j = 0; j < 4; j++) {
	            dp[j][i] = (dp[j][i] + (dp[(j+1) % 4][i-1])) % mod;
	            dp[j][i] = (dp[j][i] + (dp[(j+2) % 4][i-1])) % mod;
	            dp[j][i] = (dp[j][i] + (dp[(j+3) % 4][i-1])) % mod;
	        }
	    }
	    return dp[0][n];
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends