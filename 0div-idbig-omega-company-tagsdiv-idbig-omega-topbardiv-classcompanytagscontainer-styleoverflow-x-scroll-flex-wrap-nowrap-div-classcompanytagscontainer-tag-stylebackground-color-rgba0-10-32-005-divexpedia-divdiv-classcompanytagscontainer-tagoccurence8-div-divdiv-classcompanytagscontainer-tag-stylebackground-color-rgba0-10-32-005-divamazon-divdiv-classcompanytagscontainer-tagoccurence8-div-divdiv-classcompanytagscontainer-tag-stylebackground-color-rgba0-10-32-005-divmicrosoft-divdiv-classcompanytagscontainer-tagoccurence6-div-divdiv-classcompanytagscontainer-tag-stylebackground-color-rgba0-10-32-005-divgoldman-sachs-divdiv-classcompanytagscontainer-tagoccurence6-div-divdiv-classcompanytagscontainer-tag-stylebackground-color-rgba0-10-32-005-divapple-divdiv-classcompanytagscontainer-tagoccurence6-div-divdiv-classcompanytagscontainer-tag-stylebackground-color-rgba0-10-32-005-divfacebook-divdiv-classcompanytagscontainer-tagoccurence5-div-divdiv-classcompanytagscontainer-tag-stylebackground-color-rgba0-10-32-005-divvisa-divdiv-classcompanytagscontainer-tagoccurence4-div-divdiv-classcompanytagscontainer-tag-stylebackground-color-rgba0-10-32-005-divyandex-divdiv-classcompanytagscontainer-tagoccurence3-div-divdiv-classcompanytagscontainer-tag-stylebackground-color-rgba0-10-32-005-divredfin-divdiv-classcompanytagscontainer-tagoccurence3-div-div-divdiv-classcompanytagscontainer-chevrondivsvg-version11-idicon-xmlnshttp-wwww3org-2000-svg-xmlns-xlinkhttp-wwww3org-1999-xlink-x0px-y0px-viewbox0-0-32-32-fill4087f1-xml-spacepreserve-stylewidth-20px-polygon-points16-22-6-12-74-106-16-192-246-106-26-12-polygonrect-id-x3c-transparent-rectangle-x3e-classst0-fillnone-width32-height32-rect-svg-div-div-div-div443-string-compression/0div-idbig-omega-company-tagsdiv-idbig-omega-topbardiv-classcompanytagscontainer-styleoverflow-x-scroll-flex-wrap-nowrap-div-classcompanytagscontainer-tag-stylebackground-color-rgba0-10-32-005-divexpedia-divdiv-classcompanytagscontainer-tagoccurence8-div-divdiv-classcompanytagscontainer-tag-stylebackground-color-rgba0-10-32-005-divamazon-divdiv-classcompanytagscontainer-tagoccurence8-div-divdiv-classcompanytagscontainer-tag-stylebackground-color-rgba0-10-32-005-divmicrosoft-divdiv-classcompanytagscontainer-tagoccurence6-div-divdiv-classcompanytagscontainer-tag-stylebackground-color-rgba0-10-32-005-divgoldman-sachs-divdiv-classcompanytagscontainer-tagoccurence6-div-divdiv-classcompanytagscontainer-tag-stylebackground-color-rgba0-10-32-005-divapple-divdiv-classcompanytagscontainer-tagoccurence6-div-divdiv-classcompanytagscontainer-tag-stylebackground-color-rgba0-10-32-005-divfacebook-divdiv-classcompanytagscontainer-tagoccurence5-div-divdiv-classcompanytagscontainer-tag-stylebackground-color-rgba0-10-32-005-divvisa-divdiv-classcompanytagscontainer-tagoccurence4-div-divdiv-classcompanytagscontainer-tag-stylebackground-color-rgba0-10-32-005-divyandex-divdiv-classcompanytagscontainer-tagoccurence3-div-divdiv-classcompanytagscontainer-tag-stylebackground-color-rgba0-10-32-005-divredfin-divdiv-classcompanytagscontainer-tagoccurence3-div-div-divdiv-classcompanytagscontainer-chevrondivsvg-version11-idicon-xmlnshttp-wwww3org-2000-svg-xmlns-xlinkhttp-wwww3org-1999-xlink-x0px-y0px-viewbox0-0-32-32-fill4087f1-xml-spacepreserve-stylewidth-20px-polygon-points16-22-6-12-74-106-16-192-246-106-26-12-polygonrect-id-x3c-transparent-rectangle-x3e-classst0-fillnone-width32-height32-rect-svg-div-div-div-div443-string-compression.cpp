class Solution {
public:
    int compress(vector<char>& chars) {
        int n = chars.size();
        
        if(n == 1) {
            return chars.size();
        }
        
        string str = "";
        for(int i = 0; i < n - 1; i++) {
            int occurance = 0;
            int j = i;
            while(j < n && chars[i] == chars[j]) {
                occurance++;
                j++;
            }
            i = j - 1;
            str += chars[i];
            if(occurance > 1) {
                str += to_string(occurance);
            }
        }
        if(n >= 2 && chars[n - 2] != chars[n - 1]) {
            str += chars[n - 1];
        }
        chars.clear();
        for(int i = 0; i < str.size(); i++) {
            chars.push_back(str[i]);
        }
        return chars.size();
    }
};