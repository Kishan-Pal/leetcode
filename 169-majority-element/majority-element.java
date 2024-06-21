class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0,res=0, majority=0, n = nums.length;
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            if(map.get(nums[i]) > majority) {
                majority = map.get(nums[i]);
                res = nums[i];
            }
        }
        return res;
    }
}