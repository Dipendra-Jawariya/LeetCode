#define ll long long
class Solution {
private:
    void dfs(int &start,int &cnt,vector<vector<int>>&graph,vector<bool> &vis) {
        vis[start] = true;
        cnt++;
        for(int it: graph[start]) {
            if(!vis[it]) {
                dfs(it,cnt,graph,vis);
            }
        }
    }
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        int n = bombs.size();
        vector<vector<int>> graph(n);
        for(int i = 0; i < n; i++) {
            ll x1,y1,r1;
            x1 = bombs[i][0];
            y1 = bombs[i][1];
            r1 = bombs[i][2];
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    ll x ,y;
                    x = abs(x1 - bombs[j][0]);
                    y = abs(y1 - bombs[j][1]);
                    if((x*x + y * y) <= r1 * r1) {
                        graph[i].push_back(j);
                    }
                }
            }
        }
        int ans = -1e9;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
             vector<bool> vis(n,false);
            dfs(i,cnt,graph,vis);
            ans = max(cnt,ans);
        }
        return ans;
    }
};