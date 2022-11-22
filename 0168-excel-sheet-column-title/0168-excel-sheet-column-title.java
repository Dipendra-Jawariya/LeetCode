class Solution {
    public String convertToTitle(int n) {
        // StringBuilder sb = new StringBuilder();
        String s = "";
        while(n > 0){
            int curr = n % 26;
            if(curr == 0){
                curr  = 26;
            }
              s = (char)( 'A' + (curr - 1)) + s;
            n = n / 26;
            if(curr == 26){
                n--;
            }
        }
        return s;
    }
}