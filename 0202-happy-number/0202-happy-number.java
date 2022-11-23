class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int newNum ;
        while(true){
            newNum = 0;
//             Create the new Number 
            while(n > 0){
                int remainder = n % 10;
                newNum += remainder * remainder;
                n /= 10;
            }
            if(newNum == 1){
                return true;
            }else if(set.contains(newNum)){
                return false; // if the set has the newNum then its a endless loop
            }
            set.add(newNum);
            n = newNum;
        }
        // return false;
    }
}