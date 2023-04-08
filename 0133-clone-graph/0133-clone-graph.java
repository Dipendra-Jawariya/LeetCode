/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private void dfs(Node node,Node duplicate, Node vis[]) {
        vis[node.val] = duplicate;
        
        for(Node n : node.neighbors) {
            if(vis[n.val] == null ) {
                Node newNode = new Node(n.val);
                duplicate.neighbors.add(newNode);
                dfs(n,newNode,vis);
            } else {
                duplicate.neighbors.add(vis[n.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node duplicate = new Node(node.val);
        Node[] vis = new Node[101];
        Arrays.fill(vis,null);
        dfs(node, duplicate , vis);
        return duplicate;
    }
}