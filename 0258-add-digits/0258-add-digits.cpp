class Solution {
public:
    int addDigits(int num) {
        int ans = num;
        while(ans >= 10) {
            ans = num % 10;
            num = num/10;
            ans += num;
            num = ans;
        }
        return ans;
    }
};