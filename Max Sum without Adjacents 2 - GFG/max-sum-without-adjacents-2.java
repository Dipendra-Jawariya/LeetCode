//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int solve(int n ,int arr[],int dp[]){
        if(n<0){
            return 0;
        }
        if(n==0){
            return arr[n];
        }
        if(n == 1){
            return arr[n-1] + arr[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int case1 = arr[n] + solve(n-2,arr,dp);
        int case2 = arr[n] + arr[n-1] + solve(n-3,arr,dp);
        int case3 = 0 + solve(n-1,arr,dp);
        return dp[n] = Math.max(case1,Math.max(case2,case3));
    }
    int findMaxSum(int arr[], int n) {
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,arr,dp); 
    }
}