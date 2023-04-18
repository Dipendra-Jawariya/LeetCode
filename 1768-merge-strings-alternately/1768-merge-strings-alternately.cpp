class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int n = word1.size();
        int m = word2.size();
        
        string result = "";
        int i = 0 , j = 0;
        
        while(i < n || j < m) {
            if(i < n) {
                result.push_back(word1[i++]);
            }
            if(j < m) {
                result.push_back(word2[j++]);
            }
        }
        return result;
    }
};