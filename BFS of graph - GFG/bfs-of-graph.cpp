//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    // Function to return Breadth First Traversal of given graph.
    vector<int> bfsOfGraph(int V, vector<int> adj[]) {
        vector<vector<int>> adjlst(V);
        // Creating a graph
        // for(int i = 0; i < V; i++) {
        //     int u = adj[i][0];
        //     int v = adj[i][1];
        //     adjlst[u].push_back(v); // directed list
        // }
        
        queue<int> q;
        vector<int> vis(V,0);
        q.push(0);
        vis[0] = 1;
        
        vector<int> bfs;
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            bfs.push_back(node);
            
            for(int it : adj[node]) {
                if(vis[it] == 0) {
                    q.push(it);
                    vis[it] = 1;    
                }
            }
        }
        return bfs;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >>

            E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            // 		adj[v].push_back(u);
        }
        // string s1;
        // cin>>s1;
        Solution obj;
        vector<int> ans = obj.bfsOfGraph(V, adj);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends