class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 > len1)  return -1;
        int j = 0;
        int res = -1;
        int match = 0;
        for(int i = 0; i < len1; i++) {
            System.out.println("haystack : " + haystack.charAt(i) + " needle : " + needle.charAt(j));
            // System.out.println("needle : " + needle.charAt(j));
            if(haystack.charAt(i) == needle.charAt(j)) {
                if(res == -1) res = i;
                j++;
                match++;
                // continue;
            } else {
                if(res != -1) 
                    i -= match;
                    match = 0;
                res = -1;
                j = 0;
                // i--;
            }
            if(j == len2) {
                break;
            }
        }
        if(j != len2) return -1;
        return res;
    }
}