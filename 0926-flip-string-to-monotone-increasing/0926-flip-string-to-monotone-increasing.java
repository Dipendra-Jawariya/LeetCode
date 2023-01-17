class Solution {
    public int minFlipsMonoIncr(String s) {
        // Time Complexity:O(N)
        // Space Complexity:O(1)
        int ans  =0,num =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                ans = Math.min(num,ans+1);
            }else{
                ++num;
            }
        }
        return ans;
    }
}