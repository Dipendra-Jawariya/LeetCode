class Solution {
    public int lengthOfLongestSubstring(String s) {
         int left = 0,right = 0;
        Set<Character> seen = new HashSet<>();
        int max = 0;
        
        while(right<s.length()){
            char c = s.charAt(right); //a
            if(seen.add(c)){
                
                max = Math.max(right-left+1,max);
                right++;
            }else{
                while(s.charAt(left)!=c){
//                     removes the cahrcter before the left char
                    seen.remove(s.charAt(left));
                    left++;
                }
//                 remove the actual character
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}