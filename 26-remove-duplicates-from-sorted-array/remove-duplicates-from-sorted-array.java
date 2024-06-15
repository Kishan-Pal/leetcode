class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            if(nums[0] == nums[1]) {
                return 1;
            }
            else {
                return 2;
            }
        }
        int i = 1, j, temp;
        if(nums[0] == nums[1]){
            i = 0;
        }
        for(j=1; j<n; ) {
            temp = nums[j];
            while(j < n && nums[j] == temp) {
                j=j+1;
            }
            nums[i] = nums[j-1];
            i = i + 1;
        }
        return i;



    }
}