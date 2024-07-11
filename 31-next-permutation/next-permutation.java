class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length-1;
        while(j > 0 && nums[j-1] >= nums[j]) {
            j--;
        }
        //System.out.println(j);
        //Arrays.sort(nums, j, nums.length);
        this.reverse(nums, j, nums.length-1);
        if(j==0) return;
        int num = nums[j-1];
        int k = j;
        while(num >= nums[k]) k++;
        
        nums[j-1] = nums[k];
        nums[k] = num;
    }
    public void reverse(int[] nums, int left, int right) {
        while(left < right) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
            left++;
            right--;

        }
    }
}