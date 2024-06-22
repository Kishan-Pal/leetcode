class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int count=0, pre=0, i, n = nums.length;
        if(n==0) return ranges;
        for(i=1; i<n; i++) {
            if(nums[i-1] == nums[i] - 1) {
                count = 1;
            }
            else {
                if(count == 0) {
                    ranges.add(Integer.toString(nums[pre]));
                }
                else {
                    ranges.add(Integer.toString(nums[pre]) + "->" + Integer.toString(nums[i-1]));
                }
                count = 0;
                pre = i;
            }
        }
        if(count == 0)
            ranges.add(Integer.toString(nums[pre]));
        else
             ranges.add(Integer.toString(nums[pre]) + "->" + Integer.toString(nums[i-1]));
        return ranges;
    }
}