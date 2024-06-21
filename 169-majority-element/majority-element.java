class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0, n = nums.length;
        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
                
            }
            else {
                map.put(nums[i], 1);
                count = 1;
            }
            if(count > n/2)
                return nums[i];
        }
        return 0;
    }
}