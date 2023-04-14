class Solution {
private:
    int longestCommonSubsequence(string s1, string s2) {
        int n = s1.size();
        int m = s2.size();
        // vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        vector<int> prev(m+1,0),cur(m+1,0);
        
        for(int j = 0; j < m; j++) {
            prev[j] = 0;
        }
        
        for(int ind1 = 1; ind1 <= n; ind1++) {
            for(int ind2 = 1; ind2 <= m; ind2++) {
                if(s1[ind1-1] == s2[ind2-1]) {
                    cur[ind2] = 1 + prev[ind2-1];
                }
                else  cur[ind2] = max(prev[ind2] , cur[ind2-1]);
            }
            prev = cur;
        }
        return prev[m];
    }
public:
    int longestPalindromeSubseq(string s1) {
        int n = s1.size();
        string s2 = s1;
        reverse(s2.begin(),s2.end());
        return longestCommonSubsequence(s1,s2);
    }
};