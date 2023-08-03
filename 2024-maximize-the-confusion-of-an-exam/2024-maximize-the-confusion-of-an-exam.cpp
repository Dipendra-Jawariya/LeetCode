class Solution {
private:
    int largestWindow(string s,int k, char ch) {
        int n = s.size();
        int ans = -1e9;
        int cnt = 0;
        int left = 0 ,right = 0;
        while(right < n) {
            if(s[right] == ch) {
                cnt++;
            }
            while(cnt > k) {
                if(s[left] == ch) cnt--;
                left++;
            }
            ans = max(ans,right - left + 1);
            right++;
        }
        return ans;
    }
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        return  max(largestWindow(answerKey,k, 'F'), largestWindow(answerKey,k,'T'));
    }
};