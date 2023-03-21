//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;

// } Driver Code Ends
class Solution
{
    private:
    int f(int ind,int arr[], vector<int> &dp) {
        if(ind < 0) return 0;
        if(ind == 0) return arr[0];
        if(dp[ind] != -1) return dp[ind];
        int notTake = 0 + f(ind-1,arr,dp);
        int take = arr[ind] + f(ind-2,arr,dp);
        return dp[ind] = max(take,notTake);
    }
    public:
    //Function to find the maximum money the thief can get.
    int FindMaxSum(int arr[], int n)
    {
        vector<int> dp(n,0);
        dp[0] = arr[0];
        for(int ind = 1; ind < n; ind++) {
            int notTake = 0 + dp[ind-1];
            int take =arr[ind] ;
            if(ind>1) take += dp[ind-2];
            dp[ind] = max(take,notTake);
        }
        return dp[n-1];
    }
};

//{ Driver Code Starts.
int main()
{
    //taking total testcases
	int t;
	cin>>t;
	while(t--)
	{
	    //taking number of houses
		int n;
		cin>>n;
		int a[n];
		
		//inserting money of each house in the array
		for(int i=0;i<n;++i)
			cin>>a[i];
		Solution ob;
		//calling function FindMaxSum()
		cout<<ob.FindMaxSum(a,n)<<endl;
	}
	return 0;
}

// } Driver Code Ends