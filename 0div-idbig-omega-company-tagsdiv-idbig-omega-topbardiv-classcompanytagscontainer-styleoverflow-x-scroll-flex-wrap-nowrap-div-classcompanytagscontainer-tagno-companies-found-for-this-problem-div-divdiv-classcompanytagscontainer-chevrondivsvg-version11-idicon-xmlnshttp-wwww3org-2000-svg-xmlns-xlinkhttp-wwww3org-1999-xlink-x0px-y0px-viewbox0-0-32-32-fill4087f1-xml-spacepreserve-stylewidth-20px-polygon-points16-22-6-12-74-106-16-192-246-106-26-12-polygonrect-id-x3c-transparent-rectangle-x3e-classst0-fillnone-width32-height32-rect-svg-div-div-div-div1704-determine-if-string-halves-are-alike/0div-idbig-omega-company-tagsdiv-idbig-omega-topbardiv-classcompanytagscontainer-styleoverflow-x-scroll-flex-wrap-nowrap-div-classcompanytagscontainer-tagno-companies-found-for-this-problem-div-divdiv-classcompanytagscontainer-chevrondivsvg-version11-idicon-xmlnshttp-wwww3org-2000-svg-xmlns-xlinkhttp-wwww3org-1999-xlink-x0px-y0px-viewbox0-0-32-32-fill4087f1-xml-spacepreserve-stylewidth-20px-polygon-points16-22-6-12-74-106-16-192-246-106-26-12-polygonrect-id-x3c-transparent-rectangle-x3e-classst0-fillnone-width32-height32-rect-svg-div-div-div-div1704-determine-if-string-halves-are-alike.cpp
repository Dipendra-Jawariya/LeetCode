class Solution {
private:
    bool isVowel(char ch) {
        return ch == 'a'  || ch == 'e' || ch == 'i'  || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
public:
    bool halvesAreAlike(string s) {
        int vowel_first = 0;
        int vowel_second = 0;
        int n = s.size();
        for(int i = 0; i < n / 2; i++) {
            if(isVowel(s[i])) {
                vowel_first++;
            }
            if(isVowel(s[n-i-1])) {
                vowel_second++;
            }
        }
        return vowel_first == vowel_second;
    }
};