class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        int delete = 0 ;
         for(int j =0;j<len;j++){
            for(int i =1;i<n;i++){
                if(strs[i-1].charAt(j) > strs[i].charAt(j)){
                    delete++;
                    break;
                }else{
                    continue;
                }
            }
        }
        return delete;
    }
}