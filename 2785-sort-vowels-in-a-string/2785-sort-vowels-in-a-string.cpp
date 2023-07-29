class Solution {
private:
    bool isVowel(char ch) {
        return ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
public:
    string sortVowels(string s) {
        vector<char> vowel;
        for(auto it : s) {
            if(isVowel(it)) {
                vowel.push_back(it);
            }
        }
        if(vowel.size() == 0) return s;
        sort(vowel.begin(),vowel.end());
        for(auto it : vowel) cout<<it <<endl;
        int point = 0;
        string temp = s;
        for(int i = 0; i < s.size(); i++) {
            if(isVowel(temp[i])) {
                temp[i] = vowel[point++];
            }
        }
        return temp;
    }
};