class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        vector<bool> indegree(n,false);
        for(vector<int> & edge : edges) {
            indegree[edge[1]] = true;
        }
        vector<int> nodes;
        for(int i = 0; i < n; i++) {
            if(!indegree[i] ) {
                nodes.push_back(i);
            }
        }
        return nodes;
    }
};