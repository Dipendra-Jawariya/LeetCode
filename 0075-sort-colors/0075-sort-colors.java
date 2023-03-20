class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int temp[] = {0,0,0};
        for(int i = 0 ; i < n; i++) {
            temp[nums[i]]++;
        }
        int i = 0;
        int j = 0;
        while(j < n) {
            if(temp[i] > 0) {
                nums[j] = i;
                j++;
                temp[i]--;
            }else {
                i++;
            }
        }
    }
}