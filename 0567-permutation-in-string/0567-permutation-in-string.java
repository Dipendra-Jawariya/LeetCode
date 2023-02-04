class Solution {
    // BRUTE FORCE
    // Time complexity: O(n!)
    // Space complexity: O(n2)
 

    // boolean flag = false;
    // public boolean checkInclusion(String s1, String s2) {
    //     permute(s1,s2,0);
    //     return flag;
    // }
    // private String swap(String s, int i, int j){
    //     if(i == j) return s;
    //     String s1 = s.substring(0,i);
    //     String s2 = s.substring(i+1,j);
    //     String s3 = s.substring(j+1);
    //     return s1 + s.charAt(j) + s2 + s.charAt(i) + s3;
    // }
    // private void permute(String s1,String s2, int l){
    //     if(l == s1.length()){
    //         if(s2.indexOf(s1) >= 0){
    //             flag = true;
    //         }
    //     }
    //         for(int i = l; i < s1.length(); i++){
    //             s1 = swap(s1,l,i); //swap
    //             permute(s1,s2,l+1);
    //             s1 = swap(s1,l,i); // reswap backtrack
    //         }
    // }
    
//     private String sort(String s){
//         char[] ch = s.toCharArray();
//         Arrays.sort(ch);
//         return String.valueOf(ch);
//     }
    
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1map = new int[26];
        for(int i  = 0; i < s1.length(); i++){
            s1map[s1.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i <= s2.length() - s1.length(); i++){
            int[] s2map = new int[26];
            for(int j = 0; j < s1.length(); j++){
                s2map[s2.charAt(i+j) - 'a']++;
            }
            if(matches(s1map,s2map)){
            return true;
            }
        }
        
        return false;
    }
    private boolean matches(int[] s1map,int[] s2map){
        for(int i = 0; i < 26; i++){
            if(s1map[i] != s2map[i]){
                 return false;
            }
        }
        return true;
    }
}