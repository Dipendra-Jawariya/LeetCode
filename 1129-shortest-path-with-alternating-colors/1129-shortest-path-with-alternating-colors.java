class Pair{
    int node;
    int color;
    int level;
    Pair(int node,int color, int level) {
        this.node = node;
        this.color = color;
        this.level = level;
    }
}
class Solution {
    private List<List<List<Integer>>> createGraph(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
            graph.get(i).add(new ArrayList<>()); // for Red Color (index - 0)
            graph.get(i).add(new ArrayList<>()); // for Blue Color (index - 1)
        }
        // list to be created
        // [[[red->1], [blue->]], [[], []], [[], [1]]]

        for(int[] edge : redEdges){
            graph.get(edge[0]).get(0).add(edge[1]); // Adding in Red[0] list
        }
        for(int[] edge : blueEdges) {
            graph.get(edge[0]).get(1).add(edge[1]); // Adding in BLue(1) list
        }
        System.out.println(graph);
        return graph;
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<List<Integer>>> graph = createGraph(n,redEdges,blueEdges);
        //color -> 0 if Red  and 1 if Blue
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0));
        q.add(new Pair(0,1,0));
        
        boolean[][] visited = new boolean[n][2]; // 2d array for storing both the colors;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        
        
        // BFS
        while(!q.isEmpty()){
            int node = q.peek().node;
            int color = q.peek().color;
            int steps = q.peek().level;
            q.remove();
            // if 'node' has been visited with the 'color' already then do nothing else visit it
            if(visited[node][color]) continue;
            visited[node][color] = true;
            
           if(ans[node] == -1)  ans[node] =  steps;
            
           for(int neighbor : graph.get(node).get(color)){
               int nextColor = color == 0 ?1:0;
               if(!visited[neighbor][nextColor]){
                   q.add(new Pair(neighbor,nextColor,steps + 1));
               }
           }
        }
        return ans;
    }
    
}