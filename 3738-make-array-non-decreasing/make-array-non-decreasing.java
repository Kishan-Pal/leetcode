class Solution {
    public int maximumPossibleSize(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i: nums) {
            if(i >= max) {
                count++;
                max = i;
            }
        }
        return count;
    }
}