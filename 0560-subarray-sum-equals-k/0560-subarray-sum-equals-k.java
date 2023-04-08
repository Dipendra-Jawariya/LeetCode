class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int n = nums.length;
        int preSum = 0, cnt = 0;
        
        for(int i = 0; i < n; i++) {
            preSum += nums[i];
            int remove = preSum - k;
            if(mpp.containsKey(remove)) {
                cnt += mpp.get(remove);    
            }
            
            mpp.put(preSum , mpp.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}