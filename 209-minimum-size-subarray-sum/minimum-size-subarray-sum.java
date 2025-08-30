class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0, left = 0;
        int curSum = 0;
        int res = nums.length+1;
        while(right < nums.length) {
            curSum += nums[right];
            while(curSum >= target) {
                res = Math.min(res, right - left + 1);
                curSum -= nums[left];
                left++;
            }
            right++;
        }
        if(res == nums.length+1) {
            return 0;
        }
        else return res;
    }
}