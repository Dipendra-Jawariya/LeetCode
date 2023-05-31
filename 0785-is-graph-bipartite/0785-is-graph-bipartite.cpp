class Solution {
private:
    bool bfs_check(int node,vector<int> &color,vector<vector<int>> &graph) {
        queue<int> q;
        q.push(node);
        color[node] = 0;
        
        while(!q.empty()){
            int node = q.front();
            q.pop();
            for(int it : graph[node]) {
                if(color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.push(it);
                } else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> color(n,-1);
        
        for(int i  = 0; i < n; i++) {
            if(color[i] == -1) {
                if(bfs_check(i,color,graph) == false) {
                    return false;
                }
            }
        }
        return true;
    }
};