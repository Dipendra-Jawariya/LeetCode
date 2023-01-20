class Solution {
    private void f(int ind,int nums[],Set<List<Integer>> res,List<Integer> ds){
        if(ind == nums.length){
            if(ds.size() >= 2){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(ds.isEmpty() || ds.get(ds.size()-1) <= nums[ind]){
            ds.add(nums[ind]);
            f(ind+1,nums,res,ds);
            ds.remove(ds.size()-1);
        }
        f(ind+1,nums,res,ds);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        f(0,nums,res,new ArrayList<Integer>());
        return new ArrayList<>(res);
    }
}