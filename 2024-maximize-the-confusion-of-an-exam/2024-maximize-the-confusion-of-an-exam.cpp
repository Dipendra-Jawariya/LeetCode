class Solution {
private:
    int largestWindow(string s,int k) {
        int n = s.size();
        int ans = -1e9;
        int cntF = 0,cntT = 0;
        int left = 0 ,right = 0;
        while(right < n) {
            if(s[right] == 'F') {
                cntF++;
            }
            if(s[right] == 'T') {
                cntT++;
            }
            while(min(cntF,cntT) > k) {
                if(s[left] == 'F') cntF--;
                if(s[left] == 'T') cntT--;
                left++;
            }
            ans = max(ans,right - left + 1);
            right++;
        }
        return ans;
    }
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        return  largestWindow(answerKey,k);
    }
};