class Solution {
public:
    int myAtoi(string s) {
        int n = s.size();
        int i = 0;
        // handled leading white spaces
        while(i < n && s[i] == ' ') {
            i++;
        }
        
        long ans = 0;
        // sign
        int sign = +1;
        int flag = 0;
        if(s[i] == '-') {
            sign = -1;
            i++;
            flag++;
        }
        if(s[i] == '+') {
            i++;
            flag++;
        }
        if(flag > 1) return 0;
        while(i < s.length()) {
            if(s[i] == ' ' || !isdigit(s[i])) break;
            
            ans = ans * 10 + s[i] - '0';
            if(sign == -1 && -1 * ans < INT_MIN) return INT_MIN;
            if(sign == 1 && ans > INT_MAX) return INT_MAX;
            i++;
        }
        return (int (sign * ans));
    }
};