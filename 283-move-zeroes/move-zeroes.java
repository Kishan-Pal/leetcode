class Solution {
    public void moveZeroes(int[] nums) {
        int i=0, j, temp, n= nums.length;
        while(i < n && nums[i] != 0)
            i = i + 1;
        j = i+1;
        while(j < n) {
            if(nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i = i + 1;
            }
            j = j + 1;
        }
        
    }
}