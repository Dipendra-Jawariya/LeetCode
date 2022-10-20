class Solution {
    public void subSet(int ind,int[] nums,List<List<Integer>> ans, List<Integer> ds){
        if(ind==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[ind]);
        subSet(ind+1,nums,ans,ds);
        ds.remove(ds.size()-1);
        subSet(ind+1,nums,ans,ds);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subSet(0,nums,ans,new ArrayList<>());
        return ans;
    }
}