class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int[] sumleft = new int[n];
        sumleft[1] = nums[0];
        int[] sumright = new int[n];
        sumright[n-2] = nums[n-1];
        for(int i=2; i<n; i++) {
            sumleft[i] = sumleft[i-1] + nums[i-1];
        }
        for(int i=n-3; i>=0; i--) {
            sumright[i] = sumright[i+1] + nums[i+1];
        }
        for(int i=0; i<n; i++) {
            if(sumleft[i] == sumright[i]) return i;
        }
        return -1;
    }
}