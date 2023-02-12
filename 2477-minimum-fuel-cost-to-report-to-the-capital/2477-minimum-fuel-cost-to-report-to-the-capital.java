class Solution {
    
    // Time Complexity = O(n)
    // Space Complexity = O(n)
    long fuel;
    private long dfs(List<List<Integer>> adj,int city, int prevCity,int seats) {
        long rider = 1;
        for(int nextCity : adj.get(city)){
            if(prevCity != nextCity){ // parent check
                rider += dfs(adj,nextCity,city,seats);
            }
        }
        if(city != 0){
            fuel +=( rider + seats - 1)/seats; //Math.ceil(rider/seats)
        }
        return rider;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            // bcz its and undirected graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        fuel = 0;
        dfs(adj,0,-1,seats);
        return fuel;
    }
}