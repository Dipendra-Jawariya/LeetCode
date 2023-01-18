class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max_straight_sum = nums[0];
        int temp_max_sum = 0;
        int min_straight_sum = nums[0];
        int temp_min_sum = 0;
        int arr_sum =0;
        for(int num : nums){
            arr_sum += num;
                
            if(temp_max_sum < 0) temp_max_sum = 0;
            temp_max_sum += num;
            if(temp_max_sum > max_straight_sum) max_straight_sum = temp_max_sum;
            
            if(temp_min_sum > 0) temp_min_sum = 0;
            temp_min_sum += num;
            if(temp_min_sum < min_straight_sum) min_straight_sum = temp_min_sum;
            
        }
        if(arr_sum == min_straight_sum){
            return max_straight_sum;
        }
        return Math.max(max_straight_sum,arr_sum - min_straight_sum);
    }
}