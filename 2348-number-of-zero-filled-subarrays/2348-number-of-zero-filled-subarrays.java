class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long subarray = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                subarray += 1;
            } else {
                subarray  = 0;
            }
            ans += subarray;
        }
        return ans;
    }
}