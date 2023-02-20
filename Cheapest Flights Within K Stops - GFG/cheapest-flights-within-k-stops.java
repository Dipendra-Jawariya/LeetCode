//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair {
    int first;
    int second;
    Pair(int first,int second) {
        this.first = first;
        this.second = second;
    }
}
class Tuple {
    int stops;
    int node;
    int cost;
    Tuple(int stops,int node,int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int j = 0; j < m; j++) {
            adj.get(flights[j][0]).add(new Pair(flights[j][1],flights[j][2]));
        }
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int dist[] = new int[n];
        Arrays.fill(dist , (int)(1e9));
        dist[src] = 0;
        while(!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;
            
            if(stops > k) continue;
            for(Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;
                
                if(edW + cost < dist[adjNode] && stops <= k) {
                     dist[adjNode] = cost + edW;
                     q.add(new Tuple(stops + 1,adjNode, cost + edW));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}