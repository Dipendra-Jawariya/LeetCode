//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n+5];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n-1; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.missingNumber(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public static int missingNumber(int A[], int N)
    {
        int hash[] = new int[N+1];
        Arrays.fill(hash,0);
        for(int i = 0; i < N; i++) {
            hash[A[i]] = 1;
        }
        for(int i = 1; i <= N; i++) {
            if(hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}