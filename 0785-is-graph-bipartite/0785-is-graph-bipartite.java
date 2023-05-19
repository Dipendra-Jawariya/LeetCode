class Solution {
    private boolean bfs_check(int start,int[][] adj,int color[],int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            
            for(int it : adj[node]) {
                if(color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else  if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs_check(int node,int col,int adj[][],int color[],int n) {
        color[node] = col;
        for(int it : adj[node]) {
            if(color[it] == -1) {
                if(dfs_check(it,1-col,adj,color,n) == false) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
         
        int color[] = new int[n];
        Arrays.fill(color,-1);
        
        for(int i = 0; i < n; i++) {
            if(color[i] == -1) {
                // if(bfs_check(i,graph,color,n) == false) return false;
                if(dfs_check(i,0,graph,color,n) == false) return false;
            }
        }
        return true;
    }
}