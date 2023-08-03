class Solution {
private:
    bool isPossible(string s,int len, int k) {
        int f = 0, t = 0;
        for(int i = 0; i < len; i++) {
            t += (s[i] == 'T');
            f += ( s[i] == 'F');
        }
        
        if(t <= k || f <= k) return true;
        int l = 0, r = len - 1;
        while(r != s.size() - 1) {
            t -= (s[l] == 'T');
            f -= (s[l] == 'F');
            l++;
            
            r++;
            t += (s[r] == 'T');
            f += (s[r] == 'F');
            
            if(t <= k || f <= k) {
                return true;
            }
        }
        return false;
    }
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        int low = 1;
        int high = answerKey.size();
        
        int ans = low;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(isPossible(answerKey,mid,k) == true) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
};