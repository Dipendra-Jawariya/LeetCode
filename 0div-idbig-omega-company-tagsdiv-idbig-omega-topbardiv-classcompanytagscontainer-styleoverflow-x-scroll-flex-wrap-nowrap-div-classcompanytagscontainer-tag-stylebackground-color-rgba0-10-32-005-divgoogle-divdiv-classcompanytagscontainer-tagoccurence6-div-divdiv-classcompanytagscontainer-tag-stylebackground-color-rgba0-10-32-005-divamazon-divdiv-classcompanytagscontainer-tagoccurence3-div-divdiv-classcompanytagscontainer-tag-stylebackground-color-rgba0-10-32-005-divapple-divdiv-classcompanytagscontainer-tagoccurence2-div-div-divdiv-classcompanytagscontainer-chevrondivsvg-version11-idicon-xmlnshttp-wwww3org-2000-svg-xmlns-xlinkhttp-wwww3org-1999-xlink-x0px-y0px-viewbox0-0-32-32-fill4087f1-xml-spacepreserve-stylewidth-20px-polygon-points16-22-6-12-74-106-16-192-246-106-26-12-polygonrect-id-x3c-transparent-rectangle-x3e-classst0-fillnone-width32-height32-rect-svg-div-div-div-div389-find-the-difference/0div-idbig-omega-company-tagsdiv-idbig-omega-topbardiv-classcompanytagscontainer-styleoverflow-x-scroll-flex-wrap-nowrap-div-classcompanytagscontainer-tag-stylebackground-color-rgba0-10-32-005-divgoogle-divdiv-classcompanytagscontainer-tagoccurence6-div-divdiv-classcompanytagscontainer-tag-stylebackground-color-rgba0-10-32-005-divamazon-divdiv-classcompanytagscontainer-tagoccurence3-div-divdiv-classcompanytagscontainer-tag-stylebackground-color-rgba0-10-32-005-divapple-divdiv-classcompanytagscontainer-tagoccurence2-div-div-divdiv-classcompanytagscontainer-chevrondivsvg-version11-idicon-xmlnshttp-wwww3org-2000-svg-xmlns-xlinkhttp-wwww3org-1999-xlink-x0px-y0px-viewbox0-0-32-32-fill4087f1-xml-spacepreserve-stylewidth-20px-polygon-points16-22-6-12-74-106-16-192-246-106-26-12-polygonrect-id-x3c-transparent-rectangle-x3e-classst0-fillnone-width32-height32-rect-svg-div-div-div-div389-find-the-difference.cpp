class Solution {
public:
    char findTheDifference(string s, string t) {
        // XOR OPERATION
        char Xor = 0;
        for(char ch : s + t) {
            Xor ^= ch;
        }
        return Xor;
    }
};