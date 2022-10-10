class Solution {
    public int minSwaps(String s) {
        int misMatches =0;
        for(char ch : s.toCharArray()){
            if(ch=='['){
                misMatches++;
            }
            else{
                if(misMatches>0){
                    misMatches--;
                }
            }
        }
        return (misMatches+1)/2;
    }
}