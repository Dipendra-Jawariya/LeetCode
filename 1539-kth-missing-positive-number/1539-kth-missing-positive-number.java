class Solution {
    private boolean check(int i,int[] arr,List<Integer> list) {
        for(int k = 0; k < arr.length; k++) {
            if(i == arr[k]) return false;
            if(i < arr[k]) {
                list.add(i);
                return true;
            }
        }
        return true;
    }
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = 1; i <= arr[arr.length - 1]; i++) {
            if(check(i,arr,list)) {
                count++;
            }
            if(k == count) return list.get(list.size() - 1);
        }
        count = k - count;
        return arr[arr.length - 1] + count;
    }
}