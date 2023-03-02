class Solution {
public:
    int compress(vector<char>& chars) {
        int n = chars.size();
        int i = 0,res = 0;
        while(i < n) {
            int sameChar = 1;
            while(i + sameChar < n && chars[i] == chars[i+sameChar]) {
                sameChar++;
            }
            chars[res++] = chars[i];
            if(sameChar > 1) {
                for(char ch : to_string(sameChar)) {
                    chars[res++] = ch;
                }
            }
            i += sameChar;
        }
        return res;
    }
};