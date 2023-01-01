class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] arr = s.split(" ");
        if(pattern.length()!=arr.length)return false;
        HashMap<Character,String> map = new HashMap<>(); 
        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            boolean containsKey = map.containsKey(ch);
            if(map.containsValue(arr[i]) && !containsKey)return false;
            if(containsKey && !map.get(ch).equals(arr[i]))return false;
            else map.put(ch,arr[i]);
        }
        return true;
    }
}