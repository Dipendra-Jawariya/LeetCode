class Solution {
public:
    unordered_map<int,int> mpp;
    int dp[2000][2000];
    int solve(int i,int k,vector<int>&stones) {
        if(i == stones.size() - 1) {
            return true;
        }
        if(dp[i][k] != -1) {
            return dp[i][k];
        }
        bool k0 = false;
        bool kp = false;
        bool k1 = false;
        
        if(mpp.find(stones[i] + k) != mpp.end()) {
            k0 = solve(mpp[stones[i] + k], k,stones);
        }
        if(k > 1 && mpp.find(stones[i] + k - 1) != mpp.end()) {
            kp = solve(mpp[stones[i] + k - 1],k-1,stones);
        }
        if(mpp.find(stones[i]+ k +1) != mpp.end()) {
            k1 = solve(mpp[stones[i] +k +1] , k+1,stones);
        }
        dp[i][k] = k0 || kp || k1;
        return dp[i][k];
    }
public:
    bool canCross(vector<int>& stones) {
        if (stones[1] - stones[0] != 1) {
            return false;
        }

        for (int i = 0; i < stones.size(); i++) {
            mpp[stones[i]] = i;
        }
        
        memset(dp, -1, sizeof(dp));

        return solve(1, 1, stones);
    }
};