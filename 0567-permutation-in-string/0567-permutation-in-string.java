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
    
    private String sort(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m ) return false;
        s1 = sort(s1);
        
        for(int i = 0; i <= m - n; i++){
            String str = sort(s2.substring(i , i + n));
            if(s1.equals(str)){
                return true;
            }
        }
        return false;
    }
}