class Solution {
public:
    int minDeletions(string s) {
        vector<int> freq(26,0);
        for(char it : s) {
            freq[it - 'a']++;
        }
        sort(freq.begin(),freq.end());
        int del_operation = 0;
        for(int i = 24; i >= 0; i--) {
            if(freq[i] == 0) break;
            
            if(freq[i] >= freq[i+1]) {
                int prev = freq[i];
                freq[i] = max(0,freq[i+1] - 1);
                del_operation += prev - freq[i];
            }
        }
        return del_operation;
    }
};