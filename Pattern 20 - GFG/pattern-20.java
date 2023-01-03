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
       
        int space = 2*n-2;
       for(int i=1;i<=2*n-1;i++){
           //star
           int star = i;
           if(i>n) star = 2*n - i;
           for(int j =1;j<=star;j++){
               System.out.print("*");
           }
           //space
           for(int j =1;j<=space;j++){
               System.out.print(" ");
           }
           //star
           for(int j =1;j<=star;j++){
               System.out.print("*");
           }
           if(i< n){
               space-=2;
           }else{
               space+=2;
           }
           System.out.println();
       }
    }
}