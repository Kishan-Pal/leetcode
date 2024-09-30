class Solution {

    public void subset(int[] nums, int i, List<Integer> temp, Set<List<Integer>> result) {
        if(i == nums.length) {
            result.add(temp);
            return;
        }
        subset(nums, i+1, temp, result);
        List<Integer> temp2 = new ArrayList<>();
        for(int j: temp) {
            temp2.add(j);
        }
        temp2.add(nums[i]);
        subset(nums, i+1, temp2, result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        subset(nums, 0, temp, result);
        List<List<Integer>> result2 = new ArrayList<>();
        for(List<Integer> i: result) {
            result2.add(i);
        }
        return result2;
    }
}