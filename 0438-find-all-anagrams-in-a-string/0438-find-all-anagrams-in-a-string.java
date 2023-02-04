class Solution {
    private String sort(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<Integer>();
        int n = s.length();
        int m = p.length();
        // if( n < m ) return ls;
        
       String target = sort(p);
        
        for(int i = 0; i <= n - m; i++){
            String str = sort(s.substring(i,i + m));
                if(target.equals(str)){
                    System.out.print(i+" ");
                    ls.add(i);
                }
        }
        return ls;
    }
}