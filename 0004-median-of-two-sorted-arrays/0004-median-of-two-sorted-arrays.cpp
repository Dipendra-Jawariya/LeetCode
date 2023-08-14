class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        //brute force
        vector<int> arr3;
        int n1 = nums1.size();
        int n2 = nums2.size();
        int i = 0 , j = 0;
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                arr3.push_back(nums1[i++]);
            } else {
                arr3.push_back(nums2[j++]);
            }
        }
        while(i < n1) arr3.push_back(nums1[i++]);
        while(j < n2) arr3.push_back(nums2[j++]);
        
        int n = (n1 + n2);
        if(n % 2 == 1) return arr3[n/2];
        
        return (double)((double)(arr3[n/2]) + (double)(arr3[n/2 -1])) / 2.0;
    } 
};