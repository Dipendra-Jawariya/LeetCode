class Solution {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,int vis[] ) {
        vis[node] = 1;
        for(int it : adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        int m = isConnected[0].length;
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adj.get(j).add(i);
                    adj.get(i).add(j);    
                }
            }
        }
        int vis[] = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) {
                dfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
}