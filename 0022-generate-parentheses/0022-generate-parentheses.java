// Optimized solution
class Solution {
    private void generateAll(int ind,List<String> ans,char[] curr,int open,int close,int max){
        if(ind==curr.length){
            if(open==close ){
                ans.add(new String(curr));
            }
             return;
        }
        if(open<max){
            curr[ind] = '(';
        generateAll(ind+1,ans,curr,open+1,close,max);
        }
        if(close < open){
            curr[ind] = ')';
            generateAll(ind+1,ans,curr,open,close+1,max);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generateAll(0,ans,new char[2 * n],0,0,n);
        return ans;
    }
}


