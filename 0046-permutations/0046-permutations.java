class Solution {
    private void permutations(int ind,int[] nums,List<List<Integer>> ans){
        if(ind==nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i =0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        for(int i =ind;i<nums.length;i++){
            swap(i,ind,nums);
            permutations(ind+1,nums,ans);
            swap(i,ind,nums);
        }
    }
    private void swap(int i,int ind,int[] nums){
        int t = nums[i];
        nums[i] =nums[ind];
        nums[ind] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
//         Optimized space complexity
        List<List<Integer>> ans = new ArrayList<>();
        permutations(0,nums,ans);
        return ans;
    }
}