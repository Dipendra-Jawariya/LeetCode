class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's Algorithm
        int sum = 0;
        int maxi = nums[0]; //initial configuration
        for(int i =0;i<nums.length;i++){
            sum +=nums[i];
            if(sum > maxi) maxi = sum;
            if(sum < 0) sum = 0;
        }
        return maxi;
    }
}