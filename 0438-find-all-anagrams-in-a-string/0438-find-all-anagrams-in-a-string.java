class Solution {
    private boolean matches(int arr1[],int arr2[]){
        for(int i =0;i<26;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        
        int target[] = new int[26];
        for(int i =0;i<m;i++) {
            target[p.charAt(i) - 'a']++; 
        }
        
        for(int i =0;i<=n-m;i++){
            int str[] = new int[26];
            for(int j = 0; j < m; j++){
                str[s.charAt(i + j) -  'a']++;
            }
            
            if(matches(target,str)){
                ls.add(i);
            }
        }
        return ls;
    }
}