class Solution {
    private void func(int ind,String s,List<List<String>> res, List<String> path){
        if(ind == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i =ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                path.add(s.substring(ind,i+1));
                func(i+1,s,res,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int start,int end ){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,res,path);
        return res;
    }
}