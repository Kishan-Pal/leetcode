class Solution {
    public static int total;
    public int subsetXORSum(int[] nums) {
        total = 0;
        dfs(nums, 0, 0);
        return total;
    }
    public static void dfs(int[] nums, int i, int temp) {
        if(i == nums.length) {
            //System.out.println("Temp: " + temp);
            total += temp;
            //System.out.println("Total: " + total);
            return;
        }
        dfs(nums, i+1, temp);
        dfs(nums, i+1, temp ^ nums[i]);
    }
}