class Solution {
public:
    bool check(string s1, string s2) {
        if (s1.size() + 1 != s2.size()) return false;
        int fir = 0;
        int sec = 0;
        while (sec < s2.size()) {
            if (s1[fir] == s2[sec]) {
                fir++;
                sec++;
            }
            else {
                sec++;
            }
            if (fir == s1.size() && sec == s2.size()) return true;
        }
        return false;
    }
    static bool comp(string &s1, string &s2) {
        return s1.size() < s2.size();
    }
    int longestStrChain(vector<string>& words) {
        sort(begin(words), end(words), comp);
        int n = words.size();
        vector<int> dp(n, 1);
        int ans = INT_MIN;
        for (int ind=0; ind<n; ind++) {
            for (int prev=0; prev<ind; prev++) {
                if (check(words[prev], words[ind]) && 1 + dp[prev] > dp[ind]) {
                    dp[ind] = 1 + dp[prev];
                }
            }
            ans = max(ans, dp[ind]);
        }
        return ans;
    }
};