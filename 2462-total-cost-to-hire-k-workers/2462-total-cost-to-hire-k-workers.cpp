class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        priority_queue<int,vector<int>,greater<int>> pq1,pq2;
        long long total_cost = 0;
        int session = 0;
        int left = 0; int right = costs.size()-1;
        
        while(session < k) {
            while(pq1.size() < candidates && left <= right) pq1.push(costs[left++]);
            while(pq2.size() < candidates && right >= left) pq2.push(costs[right--]);
            int a = pq1.size() > 0 ? pq1.top() : INT_MAX;
            int b = pq2.size() > 0 ? pq2.top() : INT_MAX;
            
            if(a <= b) {
                total_cost += a;
                pq1.pop();
            } else {
                total_cost += b;
                pq2.pop();
            }
            session++;
        }
        return total_cost;
    }
};