class Solution {
public:
    int maxConsecutiveAnswers(string str, int k) {
        int n = str.size();
        int left = 0, right = 0;
        int ans = -1e9,cnt = 0;
        while(right < n) {
            if(str[right] == 'F') {
                cnt++;
            }
            while(cnt > k) {
                if(str[left] == 'F') {
                    cnt--;
                }
                left++;
            }
            ans = max(ans,right - left + 1);
            right++;
        }
        left = 0,cnt = 0,right = 0;
        while(right < n) {
            if(str[right] == 'T') {
                cnt++;
            }
            while(cnt > k) {
                if(str[left] == 'T') {
                    cnt--;
                }
                left++;
            }
            ans = max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
};