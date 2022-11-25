class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        // taking product from the right so that when we go from left we have product except the current one
        for(int i = n - 1; i >= 0 ; i--){
            if(i < n - 1){
                ans[i] = ans[i+1] * nums[i+1];
            }
            else{
                ans[i] = 1;
            }
        }
        int leftProd = 1;
        for(int i = 0; i < nums.length; i++){
            ans[i] = leftProd * ans[i];
            leftProd *= nums[i];
        }
        return ans;
    }
}