class Solution {
public:
    bool closeStrings(string word1, string word2) {
        if(word1.size() != word2.size()) return false;
        
        vector<int> word1_freq(26, 0);
        vector<int> word2_freq(26, 0);
        
        vector<bool> word1_isPresent(26,0);
        vector<bool> word2_isPresent(26,0);
        
        
        for(char ch : word1) {
            word1_freq[ch - 'a']++;
            word1_isPresent[ch - 'a'] = true;;
        }
        
        for(char ch : word2) {
            word2_freq[ch - 'a']++;
            word2_isPresent[ch - 'a'] = true;
        }
        sort(word1_freq.begin(), word1_freq.end());
        sort(word2_freq.begin(),word2_freq.end());
        
        return word1_freq == word2_freq && word1_isPresent == word2_isPresent;
    }
};