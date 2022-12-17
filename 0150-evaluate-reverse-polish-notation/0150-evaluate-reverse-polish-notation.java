class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str : tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
               int b = st.pop();
               int a = st.pop();
               int res = cal(a,b,str.charAt(0));
               st.push(res);
               }else{
                st.push(Integer.parseInt(str));
            } 
        }
        return st.pop();
    }
    private int cal(int a,int b,char oprt){
        if(oprt =='+'){
            return a + b;
        } else if(oprt == '-'){
            return  a-b; 
        } else if(oprt == '*'){
            return a*b;
        } else{
            return a/b;
        }
    }
}