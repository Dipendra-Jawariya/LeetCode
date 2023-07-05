//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	int findKRotation(int num[], int n) {
        int mini = 1e9;
        int low = 0 , high = n - 1;
        int ind = -1;
        while(low <= high) {
            int mid = (low + high) / 2; 
            
            if(num[low] <= num[mid]) {
                if(num[low] < mini) {
                    ind = low;
                    mini = num[low];
                }
                
                low  = mid + 1;
            }else {
                high = mid - 1;
                if(num[mid] < mini) {
                    ind = mid;
                    mini = num[mid];
                }
            }
        }
        return ind;
	}

};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int a[n];
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findKRotation(a, n);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends