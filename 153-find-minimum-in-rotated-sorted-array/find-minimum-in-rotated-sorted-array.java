class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1, mid;
        while(l < r) {
            mid = (l+r)/2;
            if(nums[l] < nums[r]) {
                return nums[l];
            }
            else if(nums[l] < nums[mid] && nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else if(nums[l] > nums[mid]) {
                r = mid;
            }
            else return nums[r];
        }
        return nums[l];
    }
}