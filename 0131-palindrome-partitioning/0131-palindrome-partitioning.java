class Solution {
    private void f(int ind,String s,List<List<String>> ans,List<String> ds){
        if(ind == s.length()){
            ans.add(new ArrayList<>(ds));
        }
        for(int i = ind;i < s.length(); i++){
            if(isPalindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                f(i+1,s,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        f(0,s,ans,ds);
        return ans;
    }
}