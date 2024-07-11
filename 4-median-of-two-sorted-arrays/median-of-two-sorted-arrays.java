class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] res = new int[nums1.length + nums2.length];
        int i=0, j=0, k=0, limit=0;
        while(limit <= (nums1.length+nums2.length)/2 && i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                res[k] = nums1[i];
                k++;
                i++;
            }
            else {
                res[k] = nums2[j];
                j++;
                k++;
            }
            limit++;
        }
        if(i < nums1.length) {
            while(limit <= (nums1.length+nums2.length)/2 && i < nums1.length) {
                res[k] = nums1[i];
                i++;
                k++;
                limit++;
            }
        }
        else if(j < nums2.length) {
            while(limit <= (nums1.length+nums2.length)/2 && j < nums2.length) {
                res[k] = nums2[j];
                j++;
                k++;
                limit++;
            }
        }
        if(k==0) return 0;
        if((nums1.length + nums2.length)%2 == 0) return (res[k-1] + res[k-2])/2.0;
        return res[k-1];
    }
}