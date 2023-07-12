class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
       int n = graph.size();
        vector<int> indegree(n);
        vector<vector<int>> adj(n);
        
        for(int i = 0; i < n; i++) {
            for(auto node : graph[i]) {
                adj[node].push_back(i);
                indegree[i]++;
            }
        }
        
        queue<int> q;
        for(int i = 0 ; i < n; i++) {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }
        
        vector<bool> safe(n);
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            safe[node] = true;
            
            for(auto & it : adj[node]) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.push(it);
                }
            }
        }
        vector<int> safeNodes;
        for(int i = 0; i < n; i++) {
            if(safe[i]) {
                safeNodes.push_back(i);
            }
        }
        return safeNodes;
    }
};