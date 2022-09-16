// Method 01
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j =0;
        for(int val : pushed){
            s.push(val);
            while(!s.isEmpty() && popped[j]==s.peek()){
                j++;
                s.pop();
            }
        }
        return s.isEmpty();
    }
}


// Method 02
class Solution {
   public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        s.push(pushed[0]);
        int j =0;
        int i=1;
        int counter =0;
        while(j<popped.length && counter!= popped.length  ){
           
            if(!s.isEmpty() && popped[j]==s.peek()){
                j++;
//                i--;
                s.pop();
                continue;
            }
                if(i< pushed.length){
                    s.push(pushed[i]);
                    i++;    
                }
             counter++;

        }
        if(s.isEmpty()){
            return true;
        }

        return false;
    }
}
