class Solution {
    public int search(int[] nums, int target) {
        int i=0;
        while(i < nums.length-1 && nums[i] < nums[i+1]){
            if(nums[i] == target) return i;
            i++;
        }
        if(nums[i] == target) return i;
        //System.out.println(i);

        return binarySearch(nums, i+1, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = (l+r)/2;
            //System.out.println(mid);
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public void rotate(int[] nums, int left, int right) {
        while(left < right) {
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
            left++;
            right++;

        }
    }
}