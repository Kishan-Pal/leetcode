class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        
        int[] res = new int[3];
        res[0] = nums[0];
        res[1] = 0;
        res[2] = 0;
        int k = 0;
        for(int i=1; i<n; i++) {
            if(nums[i] > res[0]) {
                res[2] = res[1];
                res[1] = res[0];
                res[0] = nums[i];
                k = k + 1;
            }
            else
            if(k==0 && nums[i] != res[0]) {
                res[1] = nums[i];
                k = k + 1;
            } 
            else if(nums[i] > res[1] && nums[i] != res[0]){
                res[2] = res[1];
                res[1] = nums[i];
                k = k + 1;
            }
        
            else
            if(k == 1 && nums[i] != res[0] && nums[i] != res[1]){
                res[2] = nums[i];
                k = k + 1;
            }
            else if(nums[i] > res[2] && nums[i] != res[0] && nums[i] != res[1]){
                res[2] = nums[i];
                k = k + 1;
            }
            
        }
        if(k >= 2)
            return res[2];
        else
            return res[0];
    }
}