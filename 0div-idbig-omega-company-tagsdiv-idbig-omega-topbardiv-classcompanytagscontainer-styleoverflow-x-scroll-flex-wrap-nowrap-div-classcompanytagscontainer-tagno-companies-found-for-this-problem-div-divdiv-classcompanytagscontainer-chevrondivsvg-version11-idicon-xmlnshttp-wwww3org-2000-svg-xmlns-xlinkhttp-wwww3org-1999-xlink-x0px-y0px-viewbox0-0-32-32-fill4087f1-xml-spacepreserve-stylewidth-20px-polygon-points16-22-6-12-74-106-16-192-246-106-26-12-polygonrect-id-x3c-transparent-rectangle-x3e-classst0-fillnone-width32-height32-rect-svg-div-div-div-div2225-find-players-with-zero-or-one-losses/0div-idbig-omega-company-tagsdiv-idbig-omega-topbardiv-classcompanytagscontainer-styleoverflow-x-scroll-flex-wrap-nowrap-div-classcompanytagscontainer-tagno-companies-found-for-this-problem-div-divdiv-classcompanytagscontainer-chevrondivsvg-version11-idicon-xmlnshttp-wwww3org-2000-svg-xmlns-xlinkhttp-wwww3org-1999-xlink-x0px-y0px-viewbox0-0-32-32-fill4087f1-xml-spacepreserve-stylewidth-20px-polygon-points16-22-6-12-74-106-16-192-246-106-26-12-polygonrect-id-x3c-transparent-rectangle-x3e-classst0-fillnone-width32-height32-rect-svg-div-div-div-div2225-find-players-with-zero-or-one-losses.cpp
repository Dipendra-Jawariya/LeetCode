class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        sort(matches.begin(),matches.end());
        int n = matches.size();
        
        map<int,int> mpp_winner;
        map<int,int> mpp_looser;
        for(int i = 0; i < n; i++) {
                mpp_winner[matches[i][0]]++;
                mpp_looser[matches[i][1]]++;
        }
        
        vector<vector<int>> ans(2);
       
        for(auto it : mpp_looser) {
            if(it.second == 1) {
                ans[1].push_back(it.first);    
            }
        }
        
         for(auto it : mpp_winner) {
             if(mpp_looser.find(it.first) == mpp_looser.end()) {
                ans[0].push_back(it.first);     
             }
        }
        return ans;
    }
};