//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> ls = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int xx,yy,zz;
        //  n1 = arr1.length;
        //  n2 = arr2.length;
        //  n3 = arr3.length;
        xx = yy = zz = 0;
        while(i < n1 && j < n2 && k < n3){
            while(i < n1 && xx == arr1[i]) i++;
            while(j < n2 && yy == arr2[j]) j++;
            while( k < n3 && zz == arr3[k]) k++;
            if((i < n1 && j < n2 && k < n3)){
                if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
                ls.add(arr1[i]);
                xx = yy = zz = arr1[i];
                i++;j++;k++;                
                }
                // x < y
                else if(arr1[i] < arr2[j]){
                    xx = arr1[i];
                    i++;
                }
                //y < z
                else if(arr2[j] < arr3[k]){
                    yy = arr2[j];
                    j++;
                }
                //z < y  && z < x i.e. z is smallest
                else{
                    zz = arr3[k];
                    k++;
                }
            }
        }
        return ls;
    }
}