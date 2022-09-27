class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int arr[] = new int[n];
        
        for(int i =2*n-1;i>=0;i--){
            while(!s.isEmpty() && nums[i%n]>=s.peek()){
                s.pop();
            }
            arr[i%n] = (s.isEmpty())?-1:s.peek();
            s.push(nums[i%n]);
        }
        return arr;
    }
}