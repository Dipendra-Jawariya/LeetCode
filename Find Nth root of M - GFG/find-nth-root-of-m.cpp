//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    private:
    long long int f(int mid,int n ,int m ) {
        long long int ans = 1;
        for(int i = 0; i < n; i++) {
            if(ans > m) break;
            ans *= mid;
        }
        return ans;
    }
	public:
	int NthRoot(int n, int m)
	{
	    int low = 1,high = m;
	    while(low <= high) {
	        int mid = (low + high ) / 2;
	        long long int num = f(mid,n,m);
	        if(num == m) {
	            return mid;
	        } else if(num > m) {
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return -1;
	}  
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		Solution ob;
		int ans = ob.NthRoot(n, m);
		cout << ans << "\n";
	}  
	return 0;
}
// } Driver Code Ends