class Solution {
private:
    int f(int i,string s,long ans,int sign) {
        if(s[i] == ' ' || !isdigit(s[i])) return (int)(sign * ans);
            ans = ans * 10 + s[i] - '0';
            if(sign == -1 && -1 * ans < INT_MIN) return INT_MIN;
            if(sign == 1 && ans > INT_MAX) return INT_MAX;
            return f(i+1,s,ans,sign);
    }
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
        
        return f(i,s,(long)0,sign);
    }
};