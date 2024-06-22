class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int n = nums.length;
        if(n==0) return ranges;

        int i=0, j=0;
        while(j<n-1) {
            if(nums[j] != nums[j+1] - 1) {
                if(i == j) {
                    ranges.add(Integer.toString(nums[i]));
                }
                else {
                    ranges.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j]));
                }
                i = j + 1;
                
            }
            j = j + 1;
        }
        if(i == j) {
            ranges.add(Integer.toString(nums[i]));
        }
        else {
            ranges.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j]));
        }
        return ranges;
    }
}