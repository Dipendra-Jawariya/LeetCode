class Solution {
    public int partitionString(String s) {
        int n = s.length();
        Set<Character> st = new HashSet<>();
        int ans = (s.isEmpty()) ? 0 : 1;
        for(int i = 0; i < n; i++) {
            if(st.contains(s.charAt(i))) {
                ans++;
                st.clear();
            }
            // Displaying the final Set after clearing;
            // System.out.println("The final set: " + st + " " + ans);
            st.add(s.charAt(i)); 
        }
        return ans;
    }
}