class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        vector<vector<int>>adj(n,vector<int>(n,0));
        vector<int>degree(n,0);
        for(auto road:roads){
            adj[road[0]][road[1]]=1;
            adj[road[1]][road[0]]=1;
            degree[road[0]]++;
            degree[road[1]]++;
        }
        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                maxi=max(maxi,degree[i]+degree[j]-adj[i][j]);
            }
        }
        return maxi;
    }
};