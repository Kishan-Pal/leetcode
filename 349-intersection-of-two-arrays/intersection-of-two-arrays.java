class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash = new int[1002];
        int[] res = new int[1002];
        int a=0;
        for(int i: nums1) {
            hash[i] = 1;
        }
        for(int i: nums2) {
            if(hash[i] == 1) {
                res[a] = i;
                hash[i] = -1;
                a = a+1;
            }
        }
        int[] result = new int[a];
        for(int i=0; i<a; i++) {
            result[i] = res[i];
        }
        return result;
    }
}