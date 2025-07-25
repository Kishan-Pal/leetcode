class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] set = new int[10001];
        int sum = 0, res = 0;
        int l=0, r=0;
        while(r < nums.length) {
            if(set[nums[r]] == 1) {
                while(nums[l] != nums[r]) {
                    sum -= nums[l];
                    set[nums[l]] = 0;
                    l++;
                }
      
                l++;
       
            }
            else {
                set[nums[r]] = 1;
                sum += nums[r];

            }
            res = Math.max(res, sum);
            // System.out.println("sum: " + sum + " res: " + res);
            r++;
        }
        
        return res;
    }
}