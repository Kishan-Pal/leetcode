class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        this.nums = nums;
    }
    //-2, -2, 1, -4, -2, -3
    public int sumRange(int left, int right) {
        if(left == 0) 
            return this.nums[right];
        else
            return this.nums[right] - this.nums[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */