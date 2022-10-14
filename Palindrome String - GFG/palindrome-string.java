//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
      return solve(0,S);
    }
    int solve(int i ,String s){
        if(i>=s.length()/2){
            return 1;
        }
        if(s.charAt(i)!=s.charAt(s.length()-i-1)){
            return 0;
        }
        return solve(i+1,s);
    }
};