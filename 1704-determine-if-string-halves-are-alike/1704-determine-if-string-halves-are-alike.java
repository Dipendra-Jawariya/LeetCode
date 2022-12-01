class Solution {
    public boolean checkVowel(char ch){
        return ch == 'a' || ch =='e'|| ch == 'i' ||  ch =='o' || ch =='u' || ch == 'A' || ch =='E' || ch =='I' || ch =='O' || ch == 'U';
    }
    public boolean halvesAreAlike(String s) {
        int vowelCount = 0;
        int n = s.length();
        for(int i =0; i < n /2; i++ ){
            if(checkVowel(s.charAt(i))){
                vowelCount++;
            }
            if(checkVowel(s.charAt(n - i - 1))){
                vowelCount--;
            }
        }
        return vowelCount == 0;
    }
}