class Solution {
public:
    int singleNonDuplicate(vector<int>& num) {
        int n = num.size();
        if(n == 1) return num[0];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(num[i] != num[i+1]) return num[0];
            } else if( i == n) {
                if(num[i] != num[i-1]) return num[i];
            } else {
                if(num[i] != num[i+1] && num[i] != num[i-1])  {
                    return num[i];
                }
            }
        }
        return -1;
    }
};