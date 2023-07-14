class Solution {
private:
    //  int f(int ind,int prev,vector<int> &arr,int diff,vector<vector<int>> &dp) {
    //     if(ind >= arr.size()) {
    //         return 0;
    //     }
    //     if(dp[ind][prev+1] != -1) {
    //         return dp[ind][prev+1];
    //     }
    //     int take = -1e9;
    //     if(prev == -1 || arr[ind] - arr[prev] == diff) {
    //         take = 1 + f(ind + 1,ind,arr,diff,dp);
    //     }
    //     int notTake = f(ind + 1,prev,arr,diff,dp);
    //     return dp[ind][prev+1] = max(take,notTake);
    // }
public:
    int longestSubsequence(vector<int>& arr, int difference) {
//         int n = arr.size(); 
//         // vector<vector<int>> dp(n+1,vector<int>(n+1,0));
//         // Tabulation
//         //Space Optimization
//         vector<int> next(n+1,0);
//         vector<int> curr(n+1,0);
//         for(int ind = n-1; ind >= 0; ind--) {
//             for(int prev = ind-1; prev >= -1; prev--) {
//                 int take = -1e9;
//                 if(prev == -1 || arr[ind] - arr[prev] == difference) {
//                     take = 1 + next[ind+1];
//                 }
//                 int notTake = 0 + next[prev+1];
                
//                 curr[prev+1] = max(take,notTake);
//             }
//             next = curr;
//         }
//         return curr[-1+1];
        
        int n = arr.size();
        unordered_map<int,int> mpp;
        int ans = 1;
        for(int i = 0; i < n; i++) {
            int num = arr[i];
            if(mpp.find(num - difference)  != mpp.end()) {
                mpp[num] = mpp[num - difference] + 1;
            } else {
                mpp[num] = 1;
            }
            ans = max(ans,mpp[num]);
        }
        return ans;
    }
};