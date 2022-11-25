class Solution {
    public int[] productExceptSelf(int[] nums) {
        long right = 1;
        int[] ans = new int[nums.length];
        for(int i = nums.length - 1; i>=0; --i){
            if(i < nums.length - 1){
                ans[i] = ans[i+1]*nums[i+1];
            }
            else{
                ans[i] = 1;
            }
        }
        
        
        int left = 1;
        for(int i = 0; i<ans.length; ++i){
            ans[i] = (left * ans[i]);
            left *= nums[i];
        }
        return ans;
    }
}
