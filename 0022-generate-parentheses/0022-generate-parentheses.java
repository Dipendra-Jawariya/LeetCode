class Solution {
    private boolean matching(char a, char b){
        return (a=='(' && b==')');
    }
    private boolean valid(char[] curr){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<curr.length;i++){
            if(curr[i]=='('){
                s.push(curr[i]);
            }
            else{
                if(s.isEmpty() || s.peek()!='('){
                    return false;
                }
                else if(matching(s.peek(),curr[i])){
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }
    private void generateAll(int ind,List<String> ans,char[] curr){
        if(ind==curr.length){
            for(char ch:curr){
                System.out.print(ch);
            }
                System.out.println();
            if(valid(curr)){
                ans.add(new String(curr));
            }
             return;
        }
        curr[ind] = '(';
        generateAll(ind+1,ans,curr);
        curr[ind] = ')';
        generateAll(ind+1,ans,curr);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generateAll(0,ans,new char[2 * n]);
        return ans;
    }
}


