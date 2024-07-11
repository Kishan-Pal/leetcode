class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();
        for(int k=0; k<nums.length-3; k++) {
            for(int i=k+1;i<nums.length-2;i++){
                int left = i+1;
                int right = nums.length-1;
                while(left<right){
                    Long sum = (long)nums[k]+(long)nums[i]+(long)nums[left]+(long)nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[left],nums[right]));
                        left++;
                        right--;
                    }
                    else if(sum<target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
       return new ArrayList<>(result);
    }
}