class Solution {
public:
    bool isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy) {
            if(t == 1) {
                return false;
            }
            return true;
        }
        int xdiff = abs(fx - sx);
        int ydiff = abs(fy - sy);
        return (min(xdiff , ydiff) + abs(xdiff - ydiff)) <= t;
    }
};