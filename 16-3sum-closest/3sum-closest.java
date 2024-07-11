class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res=0, diff=0;
        boolean empty = true;
        Arrays.sort(nums);
       /*  for(int i: nums) {
            System.out.print(i + " " );
        } */
        System.out.println();
        for(int i=0; i<nums.length-2; i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = nums.length-1, temp;
            while(l < r) {
                if(empty) {
                    res = nums[i] + nums[l] + nums[r];
                    diff = Math.abs(target - res);
                    empty = false;
                }
                else {
                    //System.out.println(nums[i] + " " + nums[l] + " " + nums[r]);
                    temp = nums[i] + nums[l] + nums[r];
                    if(Math.abs(target - temp) == 0) return temp;
                    else if(Math.abs(target - temp) < diff) {
                        res = temp;
                        diff = Math.abs(target - res);
                    }
                    if(temp > target) r--;
                    else l++;

                }
            }
        }
        return res;
    }
}