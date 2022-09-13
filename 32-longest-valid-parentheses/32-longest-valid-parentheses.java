class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        for(int i =0;i<n;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        int max = 0;
        while(!stack.isEmpty()){
            int peek = stack.pop();
            max = Math.max(max, n - peek - 1);
            n = peek;
        }
        return Math.max(n,max);
    }
}