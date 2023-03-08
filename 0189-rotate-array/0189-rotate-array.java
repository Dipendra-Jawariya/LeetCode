class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int temp[] = new int[k];
        
        for(int i = n-k; i < n; i++) {
            temp[i - (n-k)] = nums[i];
        }
        int j = n-k-1;
        for(int i = n-1;i >= k; i--) {
            System.out.println(nums[j]);
            nums[i] = nums[j--];
        }
        
        for(int i = k-1; i >=0; i--) {
            nums[i] = temp[i];
        }
    }
}