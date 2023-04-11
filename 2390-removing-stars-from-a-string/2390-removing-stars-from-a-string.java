class Solution {
    public String removeStars(String s) {
        int size  = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < size; i++) {
            if(s.charAt(i) == '*') {
                char ch = st.pop();
            } else {
                st.add(s.charAt(i));   
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
       sb.reverse();
        return sb.toString();
    }
}