class Solution {
//     Repeat it  and starting off with graphs
    public boolean validPath(int n, int[][] edges, int source, int destination) {
	List<List<Integer>> graph = buildGraph(n, edges);        
	boolean[] visited = new boolean[n];
	Queue<Integer> queue = new LinkedList<>();

	queue.offer(source);

	while(!queue.isEmpty()) {
		int current = queue.poll();

		if (current == destination) return true;

		visited[current] = true;

		for(int neighbor: graph.get(current)) {
			if (!visited[neighbor]) queue.offer(neighbor);
		}
	}

	return false;
}
    private List<List<Integer>> buildGraph(int n, int[][] edges) {
	List<List<Integer>> graph = new ArrayList<>();

	for(int i=0;i<n;i++) {
		graph.add(new ArrayList<>());
	}

	for(int[] edge: edges) {
		graph.get(edge[0]).add(edge[1]);
		graph.get(edge[1]).add(edge[0]);
	}

	return graph;
    }
}