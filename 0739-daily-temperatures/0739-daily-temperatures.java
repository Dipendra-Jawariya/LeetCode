class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int arr[] = new int[n];
        s.push(n-1);
        for(int i = n-2;i>=0;i--){
            while(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                s.pop();
            }
            int nextG = (s.isEmpty()== true)?0:s.peek();
            if((nextG-i)<0){
                arr[i] = 0;
            }else{
                arr[i] = nextG - i;    
            }
            s.push(i);
        }
        return arr;
    }
}