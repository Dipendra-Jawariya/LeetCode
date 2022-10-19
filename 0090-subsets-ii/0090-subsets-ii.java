class Solution {

    public void func(int ind, int nums[], List<List<Integer>> result, List<Integer> ds) {
        result.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i!=ind && nums[i] == nums[i - 1]) {
                continue;
            }
            ds.add(nums[i]);
            func(i + 1, nums, result, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        func(0, nums, result, new ArrayList<>());
        return result;
    }
}
