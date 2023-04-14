class Solution {
private:
    int f(int ind1,int ind2,string &s1,string &s2,vector<vector<int>> &dp) {
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(s1[ind1] == s2[ind2]) {
            return dp[ind1][ind2] = 1 + f(ind1-1,ind2-1,s1,s2,dp);
        }
        return dp[ind1][ind2] = max(f(ind1-1,ind2,s1,s2,dp) , f(ind1,ind2-1,s1,s2,dp));
    }
public:
    int longestCommonSubsequence(string s1, string s2) {
        int n = s1.size();
        int m = s2.size();
        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        
        for(int i = 0; i < n ; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < m; j++) {
            dp[0][j] = 0;
        }
        
        for(int ind1 = 1; ind1 <= n; ind1++) {
            for(int ind2 = 1; ind2 <= m; ind2++) {
                if(s1[ind1-1] == s2[ind2-1]) {
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                else  dp[ind1][ind2] = max(dp[ind1-1][ind2] , dp[ind1][ind2-1]);
            }
        }
        return dp[n][m];
    }
};