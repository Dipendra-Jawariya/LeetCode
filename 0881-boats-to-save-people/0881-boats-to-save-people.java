class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int low = 0, high = n-1;
        int ans = 0;
        
        while(low <= high) {
            ans++;
            if(people[low] +  people[high] <= limit) {
                low++;
            }
            high--;
        }
        return ans;
    }
}