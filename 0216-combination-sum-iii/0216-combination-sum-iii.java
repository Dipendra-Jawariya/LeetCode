class Solution {
    public void findCombination(int ind,int arr[],List<List<Integer>> ans,int target ,int k,List<Integer> ds){
        if(ind==arr.length){
           if(ds.size()==k ){
            if(target==0){
            ans.add(new ArrayList<>(ds));    
                }
            }
            
            return;
        }
        if(ds.size()==k ){
            if(target==0){
            ans.add(new ArrayList<>(ds));    
            }
            return;
        }
        ds.add(arr[ind]);
        findCombination(ind+1,arr,ans,target-arr[ind],k,ds);
        ds.remove(ds.size()-1);
        findCombination(ind+1,arr,ans,target,k,ds);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int num[]  ={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans = new ArrayList<>(); 
        findCombination(0,num,ans,n,k,new ArrayList<>());
        return ans;
    }
}