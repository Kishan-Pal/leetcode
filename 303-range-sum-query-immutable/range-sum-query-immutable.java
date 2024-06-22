class NumArray {
    int[] nums;
    ArrayList<Integer> sum;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.sum = new ArrayList<>();
        int n = nums.length, temp = 0;
        for(int i=0; i<n; i++){
            temp = temp + nums[i];
            sum.add(temp);
        }
    }
    //-2, -2, 1, -4, -2, -3
    public int sumRange(int left, int right) {
        if(left == 0) 
            return this.sum.get(right);
        else
            return this.sum.get(right) - this.sum.get(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */