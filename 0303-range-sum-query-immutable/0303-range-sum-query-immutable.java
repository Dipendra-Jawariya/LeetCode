class NumArray {

        int prefixSum[];
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length +1];
        for(int i =1;i <= nums.length; i++){
            // System.out.print(sum+" ");
            prefixSum[i] =prefixSum[i -1] + nums[i -1];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right +1] - prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */