class Solution {
    public int trap(int[] arr) {
        int n =arr.length;
        int res = 0;
        int lmax[] =new int[n];
        int rmax[] = new int[n];
        lmax[0] = arr[0];
        for(int i = 1;i<n;i++){
            lmax[i] = Math.max(arr[i],lmax[i-1]);
        }
        rmax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
           rmax[i] = Math.max(arr[i],rmax[i+1]);
        }
        for(int i =1;i<n-1;i++){
             res = res+(Math.min(rmax[i],lmax[i])  - arr[i]);
        }
        
        return res;
    }
}