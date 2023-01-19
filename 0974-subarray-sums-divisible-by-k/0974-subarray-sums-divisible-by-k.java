class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n =  nums.length;
        int cnt = 0;
        int sum = 0;
        int rem = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < n; i++){
            sum += nums[i];
            rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            
            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem , 0) + 1);
        }
        return cnt;
    }
}