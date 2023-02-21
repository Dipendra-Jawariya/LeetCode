class Solution {
    public int singleNonDuplicate(int[] nums) {
        //Binary Search
           // -> Boundarty checks
           //  -> Pair index property
           //     -> unique element property
           //      -> partition property
        int n = nums.length;
        int low = 0, high = n-1,mid = 0;
        if(high == 0) return nums[0];
        //Boundart Checks
        else if(nums[0] != nums[1]) return nums[0];
        else if(nums[high] != nums[high - 1])  return nums[high];
        
        while(low <= high) {
            mid = (low + high) / 2;
            // unique element check
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid +1]) {
                return nums[mid];
            }
            // Pair index Property
            if(mid % 2 != 0 && nums[mid] == nums[mid - 1] ||  mid % 2 == 0 && nums[mid] == nums[mid + 1]){
                low = mid + 1; // the order of starting at even and ending at odd is not disrupted
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
