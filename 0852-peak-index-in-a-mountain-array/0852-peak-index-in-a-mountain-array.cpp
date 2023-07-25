class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int n = arr.size();
        //cornor cases
        // if(arr[0] > arr[1]) {
        //     return arr[0];
        // }
        // if(arr[n-1] > arr[n-2]) {
        //     return arr[n-1];
        // }
        // int lastLar = arr[0];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(arr[i] > arr[i+1]) return i;
            }
            else if(i == n-1) {
                if(arr[i] > arr[n - 2]) {
                    return i;
                }
            }
            else if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                // lastLar = arr[i];
                ans = i;
            }
        }
        
        return ans;
    }
};