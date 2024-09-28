class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, res, 0);
        for(List<Integer> a: res) {
            result.add(a);
        }
        return result;
    }

    public void recursion(int[] nums, HashSet<List<Integer>> res, int i) {
        if(i == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int k: nums) {
                temp.add(k);
            }
            res.add(temp);
            return;
        }
        for(int j=i; j<nums.length; j++) {
            swap(nums, i, j);
            recursion(nums, res, i+1);
            swap(nums, i, j);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}