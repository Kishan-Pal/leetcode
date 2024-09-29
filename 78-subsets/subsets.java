class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, result);
        return result;
        
    }
    public void dfs(int[] nums, int i,List<Integer> temp,  List<List<Integer>> result) {

        if(i>=nums.length) {
            result.add(temp);
            return;
        }
        dfs(nums, i+1, temp, result);
        List<Integer> temp2 = new ArrayList<>();
        for(int j: temp) {
            temp2.add(j);
        }
        temp2.add(nums[i]);
        dfs(nums, i+1, temp2, result);
    }
}