bool compareSecondElement(vector<int>& a, vector<int>& b) {
    return a[1] < b[1];
}

class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        // int n = ;
        sort(intervals.begin(),intervals.end(),compareSecondElement);
        int ans = 0;
        int k = INT_MIN;
        for(int i = 0; i < intervals.size(); i++) {
           int x = intervals[i][0];
           int y = intervals[i][1];
            
            if(x >= k) {
                k = y;
            } else {
                ans++;
            }
        }
        return ans;
    }
};