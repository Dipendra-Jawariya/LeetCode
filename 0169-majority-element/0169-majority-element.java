class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0) +1);
        }
        for(Map.Entry<Integer,Integer> it : mpp.entrySet()) {
            if(it.getValue() > n/2) {
                return it.getKey();
            }
        }
        return -1;
    }
}