class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1, j=1, k=nums[0], count = 1;
        for(; j<nums.length; j++) {
            if(nums[j] == k){
                count++;
                if(count <= 2){
                    nums[i] = nums[j];
                    i++;
                }
            }
            else {
                k = nums[j];
                count = 1;
                nums[i] = nums[j];
                i++;
            }
            
        }
        return i;
    }
}