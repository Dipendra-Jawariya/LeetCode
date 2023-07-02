class Solution {
private:
    void maxRequest(vector<vector<int>>& requests,vector<int> indegree,int n,int index,int count,int &ans) {
        
        if(index == requests.size()) {
            for(int i = 0; i < n; i++) {
                if(indegree[i]) {
                    return;
                }
            }
            ans = max(ans,count);
            return;
        }
        
        indegree[requests[index][0]]--;
        indegree[requests[index][1]]++;
        
        maxRequest(requests,indegree,n,index+1,count+1,ans);
        indegree[requests[index][0]]++;
        indegree[requests[index][1]]--;
        
        maxRequest(requests,indegree,n,index+1,count,ans);
    }
public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        int ans = 0;
        vector<int> indegree(n,0);
        maxRequest(requests,indegree,n,0,0,ans);
        return ans;
    }
};