class Solution {
    public boolean matching(char a,char b){
        return (a=='(' && b==')') || (a=='[' && b==']') || (a=='{' && b=='}');
    }
    public boolean isValid(String s) {
        Stack<Character> stack =new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else if(!stack.isEmpty() && matching(stack.peek(),s.charAt(i))==false){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return (stack.isEmpty()==true);
    }
}