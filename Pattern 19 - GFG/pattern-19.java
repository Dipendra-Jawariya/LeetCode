//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
            int space =0;
        for(int i = 0 ;i<n;i++){
            //star
            for(int j =1;j<=n-i;j++){
                System.out.print("*");
            }
            //space
            for(int j =0;j<space;j++){
                System.out.print(" ");
            }
            //star
            for(int j =1;j<=n-i;j++){
                System.out.print("*");
            }
            space=space + 2;
            System.out.println();
        }
        space = 2*n - 2;
        for(int i = 1 ;i<=n;i++){
            //star
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            //space
            for(int j =0;j<space;j++){
                System.out.print(" ");
            }
            //star
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            space=space - 2;
            System.out.println();
        }
        
    }
}