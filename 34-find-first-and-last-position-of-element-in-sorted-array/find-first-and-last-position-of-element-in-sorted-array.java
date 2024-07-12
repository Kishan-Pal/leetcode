class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int res = binarySearch(nums, 0, nums.length-1, target);
        if(res == -1) return result;
        int l = res, r = res;
        while(l>=0 && nums[l] == target) l--;
        while(r<nums.length && nums[r] == target) r++;
        result[0] = l+1;
        result[1] = r-1;
        return result;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = (l+r)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}