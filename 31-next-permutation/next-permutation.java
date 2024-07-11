class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length-1;
        while(j > 0 && nums[j-1] >= nums[j]) {
            j--;
        }
        //System.out.println(j);
        Arrays.sort(nums, j, nums.length);
        if(j==0) return;
        int num = nums[j-1];
        int k = j;
        while(k < nums.length && num >= nums[k]) k++;
        
        nums[j-1] = nums[k];
        nums[k] = num;
    }
}