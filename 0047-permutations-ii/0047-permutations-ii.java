class Solution {
    public void permute(int nums[],Set<List<Integer>> ans,boolean freq[],List<Integer> ds){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                permute(nums,ans,freq,ds);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
       Set<List<Integer>> ans = new HashSet<>();
        boolean freq[] = new boolean[nums.length];
        permute(nums,ans,freq,new ArrayList<>());
        List<List<Integer>> list = new ArrayList<>();
        for(List a :ans){
            list.add(a);
        }
        return list;
    }
}