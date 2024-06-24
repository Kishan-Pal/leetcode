class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, max=Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            sum = sum + nums[i];
        }
        max = (max>sum? max: sum);
        for(int i=1; i<=nums.length-k; i++) {
            sum = sum - nums[i-1] + nums[i+k-1];
            max = (max>sum? max: sum);

        }
        return (max*1.0)/k;

    }
}