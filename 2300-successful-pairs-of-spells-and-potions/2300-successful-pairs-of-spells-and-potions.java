class Solution {
    private int lowerBound(int potions[],int target) {
        int low = 0, high = potions.length;
        while(low < high) {
            int mid = low + (high-low) / 2;
            if( potions[mid] < target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int maxPotion = potions[m - 1];
        
        int ans[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            int spell = spells[i];
            long minPotion = (long) Math.ceil((1.0 * success) / spell);
            // Check if we don't have any potion which can be used.
            if (minPotion > maxPotion) {
                ans[i] = 0;
                continue;
            }
            int index = lowerBound(potions, (int) minPotion);
            
            ans[i] = m-index;
        }
        return ans;
    }
}