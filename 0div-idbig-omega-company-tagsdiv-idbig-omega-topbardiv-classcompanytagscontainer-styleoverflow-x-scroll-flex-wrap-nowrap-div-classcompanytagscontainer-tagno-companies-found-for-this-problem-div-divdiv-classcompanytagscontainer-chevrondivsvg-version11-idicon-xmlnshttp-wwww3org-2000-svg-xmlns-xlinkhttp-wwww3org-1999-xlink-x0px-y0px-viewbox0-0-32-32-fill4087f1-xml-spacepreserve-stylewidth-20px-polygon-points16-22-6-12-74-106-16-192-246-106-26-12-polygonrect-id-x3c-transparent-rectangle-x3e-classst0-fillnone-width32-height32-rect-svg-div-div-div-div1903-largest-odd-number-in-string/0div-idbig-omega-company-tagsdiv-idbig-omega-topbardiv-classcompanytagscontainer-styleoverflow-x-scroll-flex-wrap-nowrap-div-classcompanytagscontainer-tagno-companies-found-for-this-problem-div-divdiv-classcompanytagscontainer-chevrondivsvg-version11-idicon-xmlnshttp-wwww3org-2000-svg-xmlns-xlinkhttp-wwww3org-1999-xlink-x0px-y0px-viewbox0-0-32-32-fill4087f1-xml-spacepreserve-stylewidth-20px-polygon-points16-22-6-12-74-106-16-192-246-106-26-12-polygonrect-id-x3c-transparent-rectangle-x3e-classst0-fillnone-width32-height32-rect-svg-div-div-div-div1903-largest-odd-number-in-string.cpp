class Solution {
public:
    string largestOddNumber(string num) {
        int n = num.size();
        string temp = "";
        for(int i = n -1; i >= 0; i--) {
            int curr = (int) num[i];
            if(temp == "" && curr % 2 != 0) {
                //odd
                temp += num[i];
            } else if(temp != ""){
                temp += num[i];
            }
        }
        reverse(temp.begin(),temp.end());
        return temp;
    }
};