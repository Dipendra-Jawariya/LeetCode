class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character,Integer>> list  = new LinkedList<Map.Entry<Character,Integer>>(map.entrySet());
//         Sort  list on the basis of Integer and character(Integer map be equal in some cases and char are different)     Input: s = "cccaaa"
                // Output: "aaaccc"
        Collections.sort(list, (a,b) -> b.getValue().compareTo(a.getValue()));
        
        StringBuilder str = new StringBuilder();
        
        for(Map.Entry<Character, Integer> e: list){
            int i = e.getValue();
            while(i>0){
                str.append(e.getKey());
                i--;
            }
        }
        return str.toString();
    }
}

















//         int ls[] =new int[s.length()];
//         for(int i = 0; i < ls.length; i++){
//               int ascii =s.charAt(i);
//             System.out.println(ascii);
//             ls[i] = ascii;
//         }
//         Arrays.sort(ls);
        
//          StringBuilder str = new StringBuilder();
//         for(int lst :ls){
//             char asciiToChar = (char) lst;
//             str.append(asciiToChar);
//         }
//         return str.toString();
   