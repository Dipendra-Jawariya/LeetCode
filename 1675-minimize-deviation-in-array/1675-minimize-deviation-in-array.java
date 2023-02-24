class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 != 0) {
                 nums[i] = 2 * nums[i];
            }
            if(nums[i] < mini) {
                mini = nums[i];
            }
            if(nums[i] > maxi) {
                maxi = nums[i];
            }
        }
        int min_deviation = maxi - mini;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        
        for(int i = 0; i < n; i++) {
            pq.add(nums[i]);
        }
        int top = 0;
        while(pq.peek() % 2 == 0) {
            top = pq.peek();
            pq.remove();
            min_deviation = Math.min(min_deviation,top - mini);
            mini = Math.min(top/2,mini);
            pq.add(top/2);
        }
        top = pq.peek();
        min_deviation = Math.min(min_deviation,top - mini);
        
        return min_deviation;
    }
} 