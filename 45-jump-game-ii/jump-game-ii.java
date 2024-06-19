class Solution {
    public int jump(int[] nums) {
        int i, n = nums.length, ans=0, ind=0;
        for(i=1; i<n; i++){
            nums[i] = (nums[i]+i > nums[i-1])?nums[i]+i:nums[i-1];
        }
        while(ind < n-1) {
            ans = ans+1;
            ind = nums[ind];
        }
        return ans;
    }
}