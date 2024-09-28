import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, 0, result);
        return result;
    }

    private void recursion(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);  
            }
            result.add(permutation);
            return;
        }

        for (int j = i; j < nums.length; j++) {
            // Swap the current element with the element at index 'i'
            swap(nums, i, j);
            recursion(nums, i + 1, result);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
