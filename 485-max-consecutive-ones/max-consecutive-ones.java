class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, start = 0, temp;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                temp = i - start;
                max = ((temp>max)? temp: max);
                start = i + 1;
            }
        }
        if(nums[nums.length-1] == 1) {
            temp = nums.length - start;
            max = ((temp>max)? temp: max);
        }
        return max;
    }
}