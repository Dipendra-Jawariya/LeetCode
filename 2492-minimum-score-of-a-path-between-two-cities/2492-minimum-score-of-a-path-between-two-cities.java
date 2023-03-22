class Pair {
    int node;
    int distance;
    Pair(int node,int distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }
        for(int edges[] : roads) {
            adj.get(edges[0]).add(new Pair(edges[1],edges[2])); // u -> {v , dist}
            adj.get(edges[1]).add(new Pair(edges[0],edges[2])); // v -> {u , dist}
        }
        int vis[] = new int[n+1];
        Arrays.fill(vis,0);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(Pair it : adj.get(node)) {
                int node_value = it.node;
                int dis = it.distance;
                ans = Math.min(dis,ans);
                if(vis[node_value] == 0) {
                    vis[node_value] = 1;
                    q.add(node_value);
                }
            }
        }
        return ans;
    }
}