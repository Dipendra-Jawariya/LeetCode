class Solution {
    public int compress(char[] chars) {
       int low = 0, res = 0;
        while(low < chars.length) {
            int sameChar = 1;
            while( low + sameChar < chars.length && chars[low] == chars[low + sameChar]) {
                sameChar++;
            }
            chars[res++] = chars[low];
            if(sameChar > 1) {
                for(char ch : Integer.toString(sameChar).toCharArray()) {
                chars[res++] = ch;
                }
            }
            
            low += sameChar;
        }
        return res;
    }
}