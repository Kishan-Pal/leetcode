class Solution {
    public int maximumProduct(int[] nums) {
        // Arrays.sort(nums);
        // return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],nums[nums.length-1]*nums[0]*nums[1]);
        int n = nums.length;
        if(n == 3) 
            return nums[0] * nums[1] * nums[2];        

        int fMax = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        int tMax = Integer.MIN_VALUE;
        int fMin = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;
        for(int i : nums){
            if(i > tMax){
                if(i > sMax){
                    if(i > fMax){
                        tMax = sMax;
                        sMax = fMax;
                        fMax = i;
                    }
                    else{
                        tMax = sMax;
                        sMax = i;
                    }
                }
                else{
                    tMax = i;
                }
            }
            if(i < sMin){
                if(i < fMin){
                    sMin = fMin;
                    fMin = i;
                }
                else{
                    sMin = i;
                }
            }
        }
        return Math.max(fMin * sMin * fMax, fMax * sMax * tMax);
    }
}