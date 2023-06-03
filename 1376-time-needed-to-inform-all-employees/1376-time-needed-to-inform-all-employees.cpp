class Solution {
    int maxTime = INT_MIN;
    void dfs(vector<int> adjList[], vector<int>& informTime, int curr, int time) {
        // Maximum time for an employee to get the news.
        maxTime = max(maxTime, time);
        
        for (int adjacent : adjList[curr]) { 
            // Visit the subordinate employee who gets the news after informTime[curr] unit time.
            dfs(adjList, informTime, adjacent, time + informTime[curr]);
        }
    }
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        vector<int> adjList[n];
        for(int i = 0; i < n; i++) {
            if(manager[i] != -1) {
                adjList[manager[i]].push_back(i);
            }
        }
        dfs(adjList,informTime,headID,0);
        return maxTime;
    }
};