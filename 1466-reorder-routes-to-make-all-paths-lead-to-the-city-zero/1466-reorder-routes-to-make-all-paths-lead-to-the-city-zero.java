class Pair {
    int node;
    int edge;
    Pair(int node,int edge){
        this.node =  node;
        this.edge = edge;
    }
}
class Solution {
    private int dfs(int node,int parent,ArrayList<ArrayList<Pair>> adj) {
        int cnt = 0;
        // vis[node] = 1;
        for(Pair list : adj.get(node)) {
                System.out.println("Node:" + node +" "+ list.node + " " + list.edge);
                if(list.node == parent) continue;
                cnt += list.edge + dfs(list.node,node,adj);
        }
        return cnt;
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = connections.length;
        for(int i = 0; i < m; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(new Pair(v,1)); // original edge
            adj.get(v).add(new Pair(u,0)); // artificial edge
        }
        // int vis[] = new int[n];
        // Arrays.fill(vis,-1);
        return dfs(0,-1,adj);
    }
}