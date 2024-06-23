class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, temp;
        Arrays.sort(nums);
        temp = nums[n-1] * nums[n-2] * nums[n-3];
        max = (max > temp? max: temp);
        temp = nums[0] * nums[n-1] * nums[n-2];
        max = (max > temp? max: temp);
        temp = nums[1] * nums[0] * nums[n-1];
        max = (max > temp? max: temp);
        temp = nums[2] * nums[1] * nums[0];
        max = (max > temp? max: temp);
        return max;
    }
}