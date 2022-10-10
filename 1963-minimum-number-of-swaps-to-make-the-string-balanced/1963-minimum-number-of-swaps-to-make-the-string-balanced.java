class Solution {
    public int minSwaps(String str) {
        Stack<Character> s =new Stack<>();
        for(char ch :str.toCharArray()){
            if(ch=='['){
                s.push(ch);
                 }
            else{
                if(!s.isEmpty() && s.peek()=='['){
                    s.pop(); 
                }
                else{
                    s.push(ch);
                }
            }
        }
//         Stack Contains invalid expreession
        int a =0,b=0;
        while(!s.isEmpty()){
            if(s.pop()=='['){
                b++;
            }
            else{
                a++;
            }
        }
        int ans  = (a+1)/2 + (b+1)/2;
        return ans/2;
    }
}