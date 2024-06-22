class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length, sum=0, res=0, i;
        sum = (n * (n+1))/2;
        for(i=0; i<n; i++)
            res = res + nums[i];
        return sum - res;
    }
}