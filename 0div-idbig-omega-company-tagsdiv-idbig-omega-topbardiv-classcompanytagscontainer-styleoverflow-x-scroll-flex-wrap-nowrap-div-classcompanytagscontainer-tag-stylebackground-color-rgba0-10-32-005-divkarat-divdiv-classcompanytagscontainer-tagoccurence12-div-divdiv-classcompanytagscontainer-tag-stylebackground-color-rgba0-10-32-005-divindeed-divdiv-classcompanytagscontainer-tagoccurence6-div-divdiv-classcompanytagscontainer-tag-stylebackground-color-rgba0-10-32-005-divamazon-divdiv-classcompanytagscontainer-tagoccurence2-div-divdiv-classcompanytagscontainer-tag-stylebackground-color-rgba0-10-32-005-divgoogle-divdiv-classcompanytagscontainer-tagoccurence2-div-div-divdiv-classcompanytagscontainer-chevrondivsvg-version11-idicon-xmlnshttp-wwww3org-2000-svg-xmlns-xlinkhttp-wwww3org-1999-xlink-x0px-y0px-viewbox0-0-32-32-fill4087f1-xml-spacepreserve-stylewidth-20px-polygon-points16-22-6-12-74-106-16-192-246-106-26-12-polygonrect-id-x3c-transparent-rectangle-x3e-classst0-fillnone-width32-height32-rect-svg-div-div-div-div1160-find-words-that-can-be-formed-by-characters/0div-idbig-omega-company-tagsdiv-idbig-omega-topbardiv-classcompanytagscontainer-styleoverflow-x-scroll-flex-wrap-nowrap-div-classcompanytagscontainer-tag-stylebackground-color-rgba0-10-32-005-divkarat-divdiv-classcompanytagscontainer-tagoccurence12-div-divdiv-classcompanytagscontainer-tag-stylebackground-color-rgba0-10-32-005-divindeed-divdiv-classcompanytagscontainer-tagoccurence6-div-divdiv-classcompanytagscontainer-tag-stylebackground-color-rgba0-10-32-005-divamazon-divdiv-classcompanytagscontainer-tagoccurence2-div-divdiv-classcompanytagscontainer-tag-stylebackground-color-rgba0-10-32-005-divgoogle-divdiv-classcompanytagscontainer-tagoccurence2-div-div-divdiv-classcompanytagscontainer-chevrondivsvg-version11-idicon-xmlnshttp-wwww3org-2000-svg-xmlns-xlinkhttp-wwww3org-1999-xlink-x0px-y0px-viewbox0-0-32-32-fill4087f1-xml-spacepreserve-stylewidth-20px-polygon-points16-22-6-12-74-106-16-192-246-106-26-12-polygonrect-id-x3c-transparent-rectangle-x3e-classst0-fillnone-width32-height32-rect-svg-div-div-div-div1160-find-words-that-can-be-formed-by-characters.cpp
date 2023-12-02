class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        unordered_map<char,int> charCount;
        // find the frequency of every character 
        for(char ch : chars) {
            charCount[ch]++;
        }
        int ans = 0;
        // iterate over words
        for(string word : words) {
            unordered_map<char,int> mpp;
            for(char ch : word) {
                mpp[ch]++;
            }
            bool good = true;
            for(auto it: mpp) {
                if(it.second > charCount[it.first]) {
                    good = false;
                    break;
                }
            }
            if(good) {
                ans += word.size();
            }
        }
        return ans;
    }
};