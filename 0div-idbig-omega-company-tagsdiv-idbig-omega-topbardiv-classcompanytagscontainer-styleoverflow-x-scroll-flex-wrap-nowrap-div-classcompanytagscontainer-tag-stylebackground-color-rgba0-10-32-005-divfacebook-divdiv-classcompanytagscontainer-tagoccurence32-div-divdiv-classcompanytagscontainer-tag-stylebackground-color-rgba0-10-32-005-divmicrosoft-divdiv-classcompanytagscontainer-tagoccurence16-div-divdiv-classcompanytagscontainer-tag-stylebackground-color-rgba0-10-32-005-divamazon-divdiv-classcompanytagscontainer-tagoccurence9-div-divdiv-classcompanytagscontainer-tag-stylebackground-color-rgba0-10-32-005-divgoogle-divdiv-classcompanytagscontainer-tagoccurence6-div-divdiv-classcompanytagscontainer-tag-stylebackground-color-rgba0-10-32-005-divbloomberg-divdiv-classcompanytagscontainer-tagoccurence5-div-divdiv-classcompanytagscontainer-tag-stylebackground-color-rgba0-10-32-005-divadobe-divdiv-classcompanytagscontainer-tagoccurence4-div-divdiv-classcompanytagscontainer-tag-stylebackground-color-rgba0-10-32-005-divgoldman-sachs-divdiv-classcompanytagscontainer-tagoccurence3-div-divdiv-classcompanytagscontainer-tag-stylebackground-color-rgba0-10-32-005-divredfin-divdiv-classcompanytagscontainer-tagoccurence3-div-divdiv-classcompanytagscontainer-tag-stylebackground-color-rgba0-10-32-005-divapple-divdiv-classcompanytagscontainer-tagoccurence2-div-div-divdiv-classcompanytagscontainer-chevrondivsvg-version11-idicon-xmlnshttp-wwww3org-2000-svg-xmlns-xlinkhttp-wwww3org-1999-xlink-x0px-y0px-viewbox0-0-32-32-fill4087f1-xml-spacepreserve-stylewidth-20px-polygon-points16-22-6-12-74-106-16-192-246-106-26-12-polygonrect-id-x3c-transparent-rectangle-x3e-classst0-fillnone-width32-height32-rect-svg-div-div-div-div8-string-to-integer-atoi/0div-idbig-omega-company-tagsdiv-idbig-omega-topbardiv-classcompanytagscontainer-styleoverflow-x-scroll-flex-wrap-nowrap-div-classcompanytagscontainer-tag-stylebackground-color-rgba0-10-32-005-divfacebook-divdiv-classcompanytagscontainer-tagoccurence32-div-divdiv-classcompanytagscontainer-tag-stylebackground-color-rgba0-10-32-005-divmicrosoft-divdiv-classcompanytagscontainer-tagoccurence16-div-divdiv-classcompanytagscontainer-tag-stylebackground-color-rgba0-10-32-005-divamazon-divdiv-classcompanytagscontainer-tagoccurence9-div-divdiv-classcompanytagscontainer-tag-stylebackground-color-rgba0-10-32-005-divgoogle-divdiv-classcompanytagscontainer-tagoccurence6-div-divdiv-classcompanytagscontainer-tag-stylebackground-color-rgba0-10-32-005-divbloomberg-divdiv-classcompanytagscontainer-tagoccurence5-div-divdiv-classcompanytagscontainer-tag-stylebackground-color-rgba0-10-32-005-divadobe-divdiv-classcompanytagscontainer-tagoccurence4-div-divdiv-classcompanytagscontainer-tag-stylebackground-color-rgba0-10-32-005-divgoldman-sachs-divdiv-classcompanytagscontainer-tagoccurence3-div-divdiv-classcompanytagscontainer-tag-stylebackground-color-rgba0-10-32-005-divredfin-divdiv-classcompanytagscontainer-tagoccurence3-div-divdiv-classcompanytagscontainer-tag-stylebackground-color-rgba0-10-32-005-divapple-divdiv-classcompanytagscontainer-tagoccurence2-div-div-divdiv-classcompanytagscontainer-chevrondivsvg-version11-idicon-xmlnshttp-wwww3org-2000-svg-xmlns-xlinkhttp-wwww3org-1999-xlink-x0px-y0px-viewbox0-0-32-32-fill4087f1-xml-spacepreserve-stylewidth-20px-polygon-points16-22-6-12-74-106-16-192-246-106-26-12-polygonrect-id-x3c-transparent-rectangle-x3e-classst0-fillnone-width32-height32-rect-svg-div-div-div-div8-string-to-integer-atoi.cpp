class Solution {
public:
    int myAtoi(string s) {
        int n = s.size();
        int i = 0;
        // removed leading whitespaces
        while(i < n && s[i] == ' ') {
            i++;
        }
        int sign = +1;
        int flag = 0;
        // sign check
        if(s[i] == '-') {
            sign = -1;
            i++;
            flag++;
        }
        if(s[i] == '+') {
            i++;
            flag++;
        }
        // there are continues occurence of sign
        if(flag > 1) {
            return 0;
        }
        
        long ans = 0;
        while(i < s.length()) {
            if(s[i] == ' ' || !isdigit(s[i])) break;
            ans = ans * 10 + s[i] - '0';
            if(sign == -1 && -1 * ans < INT_MIN) return INT_MIN;
            if(sign == 1 && ans > INT_MAX) return INT_MAX;
            i++;
        }
        return (int(sign * ans));
    }
};