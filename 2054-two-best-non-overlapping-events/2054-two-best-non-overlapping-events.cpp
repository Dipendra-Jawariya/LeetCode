class Solution {
private:
    int f(int ind,int n,int jobs,vector<vector<int>> &events,vector<vector<int>> &dp) {
        if(ind >= n || jobs == 2) return 0;
        
        if(dp[ind][jobs] != -1) {
            return dp[ind][jobs];
        }
        // perform this particular job
        vector<int> vec = {events[ind][1],INT_MAX,INT_MIN};
        // finding the next start time which is greater than end time
        int nextInd = upper_bound(events.begin(),events.end(), vec)  - events.begin();
        
        int pick = events[ind][2] + f(nextInd,n,jobs+1,events,dp);
        // i cannot perform this job
        int notPick = f(ind + 1,n,jobs,events,dp);
        
        return dp[ind][jobs] = max(pick,notPick);
    }
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        int n = events.size();
        int k = 2;
        sort(events.begin(),events.end());
        vector<vector<int>> dp(n,vector<int>(k+1,-1));
        return f(0,n,0,events,dp);
    }
};