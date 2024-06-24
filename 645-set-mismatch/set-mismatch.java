class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] a = new int[10002];
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++) {
            a[nums[i]] = a[nums[i]] + 1;
            if(a[nums[i]] == 2) {
                res[0] = nums[i];
            }
        }
        for(int i=1; i<=nums.length; i++) {
            if(a[i] == 0) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
}