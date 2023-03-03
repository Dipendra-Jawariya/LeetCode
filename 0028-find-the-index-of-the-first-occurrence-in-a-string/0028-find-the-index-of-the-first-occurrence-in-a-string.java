class Solution {
    public int strStr(String haystack, String needle) {
        int n  = haystack.length();
        int m = needle.length();
        
        for(int windowStart = 0; windowStart <= n - m; windowStart++) {
            for(int i = 0; i < m; i++) {
                if(needle.charAt(i) != haystack.charAt(windowStart+i)) {
                    break;
                }
                if(i == m - 1) {
                    return windowStart;
                }
            }
        }
        return -1;
    }
}