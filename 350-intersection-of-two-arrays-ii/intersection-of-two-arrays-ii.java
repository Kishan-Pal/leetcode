class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash = new int[1002];
        int[] res = new int[1002];
        int a=0;
        for(int i: nums1) {
            hash[i] = hash[i] + 1;
        }
        for(int i: nums2) {
            if(hash[i] > 0) {
                res[a] = i;
                a = a+1;
                hash[i] = hash[i] - 1;
            }
        }
        int[] result = new int[a];
        for(int i=0; i<a; i++) {
            result[i] = res[i];
        }
        return result;
    }
}