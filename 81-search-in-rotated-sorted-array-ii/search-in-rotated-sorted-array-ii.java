class Solution {
    public boolean search(int[] nums, int target) {
        int i;
        for(i=0; i<nums.length; i++) {
            if(nums[i] == target) return true;
            if(i < nums.length-1 && nums[i] > nums[i+1]) {
                break;
            }
        }

        int l = i+1, r = nums.length-1;
        while(l <= r) {
            int mid = (l+r) / 2;
            if(nums[mid] == target) return true;
            else if(target < nums[mid]) {
                r = mid-1;

            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}