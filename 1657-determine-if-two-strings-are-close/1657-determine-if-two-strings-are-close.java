class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> word1Map =  new HashMap<>();
        Map<Character, Integer> word2Map =  new HashMap<>();
        
        for(char ch : word1.toCharArray()){
            word1Map.put(ch , word1Map.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch : word2.toCharArray()){
            word2Map.put(ch, word2Map.getOrDefault(ch, 0) + 1);
        }
//         return false the char count in word1 string is not equal to word2's count
        // EXAMPLE -  word1 = "a", word2 = "aa"
        if(!word1Map.keySet().equals(word2Map.keySet())){
            return false;
        }
// if keySet are equal then we will determine if the frequeny of the word is eqaul for particular index 
        List<Integer> word1Frequency = new ArrayList<>(word1Map.values());
        List<Integer> word2Frequency = new ArrayList<>(word2Map.values());
        Collections.sort(word1Frequency);
        Collections.sort(word2Frequency);
        return word1Frequency.equals(word2Frequency);
    }
}