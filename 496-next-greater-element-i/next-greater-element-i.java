class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int i, j;
        for(i=0; i<nums2.length; i++) {
            hash.put(nums2[i], i);
        }
        for(i=0; i<nums1.length; i++) {
            for(j=hash.get(nums1[i])+1; j<nums2.length; j++) {
                if(nums2[j] > nums1[i]) {
                    nums1[i] = nums2[j];
                    break;
                }
            }
            if(j == nums2.length) {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}