class Solution {
    public int maxSubArray(int[] nums) {
        int cursum = 0;
        int maxsum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            
            maxsum = Math.max((cursum = Math.max(nums[i], nums[i] + cursum)), maxsum);
        }
        return maxsum;
        
    }
}