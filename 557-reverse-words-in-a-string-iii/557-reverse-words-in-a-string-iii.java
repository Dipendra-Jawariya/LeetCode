class Solution {
    public String reverseWords(String s) {
         String res="";
        for(String str: s.split(" ")) res+=new StringBuilder(str).reverse().toString()+" ";
        return res.trim();
    }
}