class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0, j, n=nums.length;
        while(i<n && nums[i] != val){
            i = i+1;
        }
        for(j=i+1; j<n; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i = i+1;
            }
        }
        return i;
    }
}