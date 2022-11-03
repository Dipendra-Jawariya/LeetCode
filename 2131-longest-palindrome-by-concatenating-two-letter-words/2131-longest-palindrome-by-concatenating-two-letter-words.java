class Solution {
    public int longestPalindrome(String[] words) {
//     Counting the number of occurrences of each word using a hashmap.
        Map<String, Integer> count = new HashMap<String, Integer>();
        for(String word : words){
            Integer countOfWord = count.get(word);
            if(countOfWord == null){
                count.put(word,1);
            }
            else{
                count.put(word, countOfWord + 1);
            }
        }
//     2.    
        int answer = 0;
        boolean central = false;
        for(Map.Entry<String, Integer> entry : count.entrySet()){
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();
            // if the word is a palindrome
            if(word.charAt(0) == word.charAt(1)){
                //if the word's value is even too
                if (countOfTheWord % 2 == 0){
                    answer += countOfTheWord;
                } else {
                    // if the word's values is odd so we are lefting out one in the map and marking cetral to true it will denote weather we can use it at the centre or not
                    answer += countOfTheWord - 1;
                    central = true;
                }   
                     // consider a pair of non-palindrome words such that one is the reverse of another
            } else if(word.charAt(0) < word.charAt(1)) {
                String reverseWord = "" + word.charAt(1) + word.charAt(0);
                if (count.containsKey(reverseWord)){
                    answer += 2 * Math.min(countOfTheWord, count.get(reverseWord));
                }
            }
        }
        if(central){
            answer++;
        }
        return 2 * answer;
    }
}