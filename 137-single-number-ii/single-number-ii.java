class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0; i<32; i++) {
            int count = 0;
            for(int j: nums) {
                j = j >> i;
                count += j & 1;
            }
            count %= 3;
            count = count << i;
            res |= count;
        }
        return res;
    }
}