class Solution {
    private void swap(int i,int j ,int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int low,int high,int nums[]) {
        while(low <= high) {
            swap(low,high,nums);
            low++;
            high--;
        }
    }
    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                ind = i;
                break;
            }
        }
        if(ind == -1) {
            reverse(0,nums.length-1,nums);
            return;
        }
        for(int i = n-1; i >= ind; i--) {
            if(nums[i] > nums[ind]) {
                swap(i,ind,nums);
                break;
            }
        }
        reverse(ind+1,nums.length-1,nums);
    }
}