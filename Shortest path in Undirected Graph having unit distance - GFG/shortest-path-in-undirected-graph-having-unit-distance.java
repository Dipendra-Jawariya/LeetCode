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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0; i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            //bcz its an undirected graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int dist[] = new int[n];
        Arrays.fill(dist,(int)(1e9));
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it : adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        for(int i = 0; i < n;i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}