class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1, count = 1, n = nums.length;
        for(int i=0; i<n-1; i++) {
            if(nums[i] < nums[i+1]) {
                count = count + 1;
            }
            else {
                res = (count > res? count: res);
                count = 1;
            }
        }
        res = (count > res? count: res);
        return res;

    }
}