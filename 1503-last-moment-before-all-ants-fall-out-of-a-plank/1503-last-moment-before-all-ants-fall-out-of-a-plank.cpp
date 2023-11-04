class Solution {
public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        int lastMovement = 0;
        for(auto l : left) {
            lastMovement = max(lastMovement,l);
        }
        for(auto r : right) {
            lastMovement = max(lastMovement,n - r);
        }
        return lastMovement;
    }
};