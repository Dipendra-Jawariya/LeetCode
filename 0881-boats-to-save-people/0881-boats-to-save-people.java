class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int low = 0,high = n-1;
        int ans = 0;
        while(low <= high) {
            if(people[high] < limit && people[high] + people[low] <= limit) {
                ans++;
                low++;
                high--;
            } else {
                System.out.println(people[high]);
                ans++;
                high--;
            }
        }
        return ans;
    }
}