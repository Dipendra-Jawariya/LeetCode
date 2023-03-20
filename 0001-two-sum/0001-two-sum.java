class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int rem = target -  nums[i]; 
            if(map.containsKey(rem)) {
                return new int[]{map.get(rem),i};
            } else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}