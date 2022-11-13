class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        String[] strArray = null;  
        //converting using String.split() method with whitespace as a delimiter  
        strArray = s.trim().split(" "); 
        // String[] strArray = new String[] {s};  
        Stack<String> st = new Stack<>();
        for(int i = 0; i < strArray.length; i++){
            if(strArray[i]!="")
            st.add(strArray[i].trim()); 
        }
        while(!st.isEmpty())  {
            String string = st.pop().trim();
            str.append(string + " ");
            // str.append(" ");
        }
        return str.toString().trim();
    }
}